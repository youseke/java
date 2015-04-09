package ex08_13;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import ex08_12.NewClass.TestCase;
import ex08_12.NewClass.TestCases;

/**
 *
 * @author Tohtetsu CHoh
 */
@SupportedAnnotationTypes({"ex08_12.NewClass.TestCase", "ex08_12.NewClass.TestCases"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NewClass extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        String className = null;
        Map<String, List<TestCase>> map = new HashMap<>();
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                TestCase[] testCases = element.getAnnotation(TestCases.class) != null
                        ? element.getAnnotation(TestCases.class).value()
                        : null;
                if (testCases == null) {
                    testCases = new TestCase[]{element.getAnnotation(TestCase.class)};
                }
                map.put(element.getSimpleName().toString(), Arrays.asList(testCases));
                if (className == null) {
                    className = ((TypeElement) element.getEnclosingElement()).getQualifiedName().toString();
                }
            }
        }
        try {
            write(className, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void write(String className, Map<String, List<TestCase>> map) throws IOException {
        JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile("C8E13Test");
        try (PrintWriter out = new PrintWriter(sourceFile.openWriter())) {
            int i = className.lastIndexOf(".");
            if (i > 0) {
                out.print("package ");
                out.print(className.substring(0, i));
                out.println(";");
            }
            out.println("import static " + className + ".*;");
            out.println("public class C8E13Test {");
            out.println("   public static void main(String[] args) {");
            map.keySet().stream().forEach(m -> map.get(m).stream().forEach(a -> {
                out.println("       if(" + m + "(" + a.params() + ") == " + a.expected() + ") System.out.println(\"Passed\");");
                out.println("       else System.out.println(\"Failed\");");
            }));
            out.println("   }");
            out.println("}");
        }
    }
}
