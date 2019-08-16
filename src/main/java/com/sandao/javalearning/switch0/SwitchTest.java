package com.sandao.javalearning.switch0;

import com.sandao.javalearning.user.CareerEnum;

import java.util.Arrays;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/14
 */
public class SwitchTest {

    public static void main(String[] args) {
        testSwitch();
    }

    //编译成功
    private static void testSwitch() {
        Arrays.stream(CareerEnum.values()).forEach(careerEnum -> {
            switch (careerEnum) {
                case WRITER:
                    System.out.println("my job is :" + CareerEnum.WRITER.getName());
                    break;
                case ENGINEER:
                    System.out.println("my job is :" + CareerEnum.ENGINEER.getName());
                    break;
                default:
                    System.out.println("i have no job");
            }
        });
    }

    //编译失败
//    private static void testSwitch2() {
//        Arrays.stream(CareerEnum.values()).forEach(careerEnum -> {
//            switch (careerEnum) {
//                case CareerEnum.WRITER:
//                    System.out.println("my job is :" + CareerEnum.WRITER.getName());
//                    break;
//                case CareerEnum.ENGINEER:
//                    System.out.println("my job is :" + CareerEnum.ENGINEER.getName());
//                    break;
//                default:
//                    System.out.println("i have no job");
//            }
//        });
//    }
//
//    //编译失败
//    private static void testSwitch3() {
//        switch ("writer") {
//            case CareerEnum.WRITER.getCode():
//                System.out.println("my job is :" + CareerEnum.WRITER.getName());
//                break;
//            case CareerEnum.ENGINEER.getCode():
//                System.out.println("my job is :" + CareerEnum.ENGINEER.getName());
//                break;
//            default:
//                System.out.println("i have no job");
//        }
//    }
}
