package cn.edu.tju.scs.web.aspect;

import cn.edu.tju.scs.web.annotation.Login;
import cn.edu.tju.scs.dto.response.BizCode;
import cn.edu.tju.scs.dto.response.Result;
import cn.edu.tju.scs.entity.User;
import cn.edu.tju.scs.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by catold on 15/12/18.
 */
@Component
@Aspect
public class LoginAspect {

    @Autowired
    private UserService userService;

    @Pointcut("execution(* cn.edu.tju.scs.web.controller.*.*(..)) && !withoutAuthorization()")
    public void loginCheck() {

    }

    @Pointcut("execution(* cn.edu.tju.scs.web.controller.UserController.login*(..))")
    public void withoutAuthorization() {

    }

    @Pointcut("execution(* cn.edu.tju.scs.web.controller.*.*(..)) &&  @annotation(login)")
    public void pointcutWithAnnotation(Login login) {}


//    @Around("loginCheck()")
//    public Object validateUser(ProceedingJoinPoint jp) throws Exception {
//        System.out.println("test" + SessionUtil.isLogin());
//        if (!SessionUtil.isLogin()) {
//            // 未登录验证
//            StateCode stateCode = StateCode.buildCode(BizCode.WITHOUT_AUTHORIZATION);
//            stateCode.addData("loginUrl", Config.CAS_LOGIN_URL);
//            return stateCode;
//        }
//
//        try {
//            // 权限验证
//            MethodSignature signature = (MethodSignature) jp.getSignature();
//            Method method = signature.getMethod();
//            if (method.getAnnotationsByType(RequiredAdmin.class) != null && SessionUtil.isAdmin()) {
//                return StateCode.buildCode(BizCode.WRONGPERMISSION);
//            }
//            return jp.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            return StateCode.buildCode(BizCode.FAIL);
//        }
//    }


    @Around(value = "pointcutWithAnnotation(login)", argNames = "pjp,login")
    public Object aroundAuthentication(ProceedingJoinPoint pjp,Login login) throws Throwable {
        Object obj;
        System.out.println("@Around：执行目标方法之前...");

        boolean required = login.required();

        //访问目标方法的参数：
        Object[] args = pjp.getArgs();

        if(required){
            User user = userService.getUserFromRedis("eb049129b5574183972e7cf85f69bab02");
            if(user == null){
                return new Result<String>(BizCode.FAIL,"未登录!");
            }else{
                obj = pjp.proceed();
            }
        } else {
            obj = pjp.proceed();
        }
        System.out.println("@Around：执行目标方法之后...");

        return obj;
    }

}
