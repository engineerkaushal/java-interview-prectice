package InterviewQuestions;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // ensures annotation is available during execution

@Target(ElementType.METHOD) // defines where we can use this annotation (fields, parameters)

@Documented // makes annotation appear in code documentation

// @Constraint tells Spring that this annotation has validation logic

public @interface customAn {
    String message() default "Invalid value";

    Class<?>[] groups() default {};

    //Class<? extends Payload>[] payload() default {};
}
