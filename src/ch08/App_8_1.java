package ch08;

import kotlin.jvm.functions.Function1;

/**
 * Created by lambor on 17-6-1.
 */
public class App_8_1 {
    public static void main(String[] args) {
//        ExampleKt.process
        DemoUtils.processTheAnswer(i->i*i);

        DemoUtils.processTheAnswer(new Function1<Integer, Integer>() {
            @Override
            public Integer invoke(Integer integer) {
                return integer * integer;
            }
        });

        DemoUtils.processTheAnswer(null);
    }
}
