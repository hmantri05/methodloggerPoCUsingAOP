package com.himanshumantri.methodlogger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLogger {

	@Around("execution(* *(..)) && @annotation(com.jcabi.aspects.Loggable)")
	public Object around(ProceedingJoinPoint point) throws Throwable {

		// Implement toString() for all the objects so that it logs a readable text
		logMethodEnterance(point);
		Object result = point.proceed();
		logMethodExit(result, point);

		return result;
	}

	private void logMethodExit(Object result, ProceedingJoinPoint point) {
		String logString = "";
		MethodSignature methodSignature = (MethodSignature) point.getSignature();
		String methodName = methodSignature.toShortString();

		String returnType = methodSignature.getReturnType().getSimpleName();
		logString += "Exiting " + methodName;
		if (!returnType.equalsIgnoreCase("void")) {
			logString += " :: returning = " + result.toString();
		}
		System.out.println(logString);
	}

	private void logMethodEnterance(ProceedingJoinPoint point) {
		String logString = "";
		MethodSignature methodSignature = (MethodSignature) point.getSignature();
		String methodName = methodSignature.toShortString();
		String[] parameterNames = methodSignature.getParameterNames();
		Object[] arguments = point.getArgs();

		logString += "Entering " + methodName + " :: ";

		for (int i = 0; i < parameterNames.length; i++) {
			String paramName = parameterNames[i];
			logString += paramName + " = " + arguments[i].toString();

			if (i < parameterNames.length - 1) {
				logString += ", ";
			}
		}
		System.out.println(logString);
	}
}
