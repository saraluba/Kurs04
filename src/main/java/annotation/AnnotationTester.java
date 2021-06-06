package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class AnnotationTester {
    public static void main(String[] args) {
        Book shadowAndBone = new Book("Shadow and Bone", 352);
        Book.addBook(shadowAndBone);
        Class<? extends Book> aClass = shadowAndBone.getClass();
        Annotation[] annotations = aClass.getAnnotations();
        Method[] methods = aClass.getMethods();

    }
}
