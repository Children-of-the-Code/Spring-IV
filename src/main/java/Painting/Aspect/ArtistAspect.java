package Painting.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ArtistAspect {
    /*
    One of the interesting things about spring is how much is reduces repetitive code..
    oftentimes in our development we have something that spring refers to as a
    "cross cutting concern" - this is some functionality that is present across multiple
    methods and classes

    For instance, if we wanted to maintain a log of all endpoints that user access
    (for our metrics gathering at our company) - we would need to write code in every
    controller method that saved some record of all actions performed by users

    Or, if we wanted to implement a security check before every method of a service class -
    for instance, to check if a user is logged in before any user service method is called

    Or, and this is one that Spring provides for us, we want to wrap our repository methods
    inside of a database transaction, so that multiple repository method executions do not
    alter each other (ACID compliance) - ie this is how @Transactional works

    If we have many controller methods, this will get very repetitive
    Spring introduces something called aspects, which eleminate the need for cross cutting concerns
    in their respective classes
     */
    @Before("execution(* Painting.Service.ArtistService.*(..))")
    public void PrintBeforeArtistServiceMethod(JoinPoint joinPoint){
//        I want to print out the methods that I am calling in artistService
        System.out.println("ARTISTSERVICE JOINPOINT: "+joinPoint.getSignature());
//        BEFORE the execution of an artistService method, ATTACH this code to (the joinpoint)
    }
    /*
    anatomy:
    @Before - advice - defines at what point does our code get executed around the method that's found
    we also have
    @After
    @Around
    @BeforeThrowing
    @AfterReturning

    Pointcut expression : this defines the methods where the advice will be applied
    we typically use different wildcard expressions to apply this to multiple methods -
    * = anything
    .. = the entirety of a list of items (eg all parameters of a method)

    disected: execution(* Painting.Service.ArtistService.*(..))
    AT THE EXECUTION OF (any return type method of) Painting.Service.ArtistService.(anymethod)(anyarguments)), DO THIS:
    this gives a joinpoint, which is the point that a pointcut expression has found for us to link our advice method to
     */

    @Before("execution(* getArtist*(..))")
    public void printAllGetArtistMethods(JoinPoint joinPoint){
        System.out.println("GET JOINPOINT: "+joinPoint.getSignature());
    }
    @Before("execution(* getAll*(..))")
    public void printAllGetAllMethods(JoinPoint joinPoint){
        System.out.println("GET JOINPOINT: "+joinPoint.getSignature());
    }
    @After("execution(* something(..))")
    public void printBeforeSomethingMethods(JoinPoint joinPoint){
        System.out.println("after something");
    }
    /*
    AOP: realistically, just for logging/debugging for now
     */
}
