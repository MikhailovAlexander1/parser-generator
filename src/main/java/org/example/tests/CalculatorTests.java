package org.example.tests;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorTests {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String[] tests = {
            "1 + 2",
            "3 * 4 + 5",
            "(6 + 7) * 8",
            "9 - (10 / 2)",
            "(11 + (12 * 2)) / 3",
            "4 + (5 * (6 + 7))",
            "((8 + 9) * 10) - 11",
            "12 / (13 - (14 / 2))",
            "(15 + (16 * (17 - 3))) / 2",
            "18 * (19 + (20 / 5)) - 6",
            "((21 / 3) + 22) * (23 - 7)",
            "24 - ((25 + 26) * (27 / 9))",
            "(28 + (29 * (30 - (31 / 2)))) * 3",
            "32 / (33 - (34 + (35 * 2)))",
            "((36 + 37) * (38 / 2)) + (39 * 40)",
            "41 - ((42 / (43 + 44)) * 45)",
            "(46 + (47 * (48 - (49 / (50 + 2))))) * 3",
            "51 * ((52 / 53) + (54 - (55 * 2)))",
            "((56 + 57) - 58) * ((59 / 60) + 61)",
            "62 - ((63 + (64 * (65 - 66))) / (67 + 68))",
            "(69 * (70 + (71 / (72 - 2)))) - 73",
            "74 + ((75 - 76) * (77 + (78 / (79 * 3))))",
            "((80 / 4) + 81) * ((82 - 83) + (84 * 85))",
            "86 - ((87 / (88 + 89)) * (90 - (91 * 2)))",
            "(92 + (93 * (94 - (95 / (96 + 4))))) * 5",
            "97 * ((98 / 99) + (100 - (101 / 3)))",
            "((102 + 103) - 104) * ((105 / 106) + 107)",
            "108 - ((109 + (110 * (111 - 112))) / (113 + 114))",
            "(115 * (116 + (117 / (118 - 2)))) - 119",
            "120 + ((121 - 122) * (123 + (124 / (125 * 3))))",
            "((126 / 4) + 127) * ((128 - 129) + (130 * 131))",
            "132 - ((133 / (134 + 135)) * (136 - (137 * 2)))",
            "(138 + (139 * (140 - (141 / (142 + 4))))) * 5",
            "143 * ((144 / 145) + (146 - (147 / 3)))",
            "((148 + 149) - 150) * ((151 / 152) + 153)",
            "154 - ((155 + (156 * (157 - 158))) / (159 + 160))",
            "(161 * (162 + (163 / (164 - 2)))) - 165",
            "166 + ((167 - 168) * (169 + (170 / (171 * 3))))",
            "((172 / 4) + 173) * ((174 - 175) + (176 * 177))",
            "178 - ((179 / (180 + 181)) * (182 - (183 * 2)))",
            "(184 + (185 * (186 - (187 / (188 + 4))))) * 5",
            "189 * ((190 / 191) + (192 - (193 / 3)))",
            "((194 + 195) - 196) * ((197 / 198) + 199)",
            "200 - ((201 + (202 * (203 - 204))) / (205 + 206))",
            "(207 * (208 + (209 / (210 - 2)))) - 211",
            "212 + ((213 - 214) * (215 + (216 / (217 * 3))))",
            "((218 / 4) + 219) * ((220 - 221) + (222 * 223))",
            "224 - ((225 / (226 + 227)) * (228 - (229 * 2)))",
            "(230 + (231 * (232 - (233 / 234))))",
            "235 - ((236 + (237 * (238 - 239))) / (240 + 241))",
            "242 + ((243 - 244) * (245 + (246 / (247 * 3))))",
            "((248 / 4) + 249) * ((250 - 251) + (252 * 253))",
            "254 - ((255 / (256 + 257)) * (258 - (259 * 2)))",
            "(260 + (261 * (262 - (263 / (264 + 4))))) * 5",
            "265 * ((266 / 267) + (268 - (269 / 3)))",
            "((270 + 271) - 272) * ((273 / 274) + 275)",
            "276 - ((277 + (278 * (279 - 280))) / (281 + 282))",
            "(283 * (284 + (285 / (286 - 2)))) - 287",
            "288 + ((289 - 290) * (291 + (292 / (293 * 3))))",
            "((294 / 4) + 295) * ((296 - 297) + (298 * 299))",
            "300 - ((301 / (302 + 303)) * (304 - (305 * 2)))",
            "(306 + (307 * (308 - (309 / (310 + 4))))) * 5",
            "311 * ((312 / 313) + (314 - (315 / 3)))",
            "((316 + 317) - 318) * ((319 / 320) + 321)",
            "322 - ((323 + (324 * (325 - 326))) / (327 + 328))",
            "(329 * (330 + (331 / (332 - 2)))) - 333",
            "334 + ((335 - 336) * (337 + (338 / (339 * 3))))",
            "((340 / 4) + 341) * ((342 - 343) + (344 * 345))",
            "346 - ((347 / (348 + 349)) * (350 - (351 * 2)))",
            "(352 + (353 * (354 - (355 / (356 + 4))))) * 5",
            "357 * ((358 / 359) + (360 - (361 / 3)))",
            "((362 + 363) - 364) * ((365 / 366) + 367)",
            "368 - ((369 + (370 * (371 - 372))) / (373 + 374))",
            "(375 * (376 + (377 / (378 - 2)))) - 379",
            "380 + ((381 - 382) * (383 + (384 / (385 * 3))))",
            "((386 / 4) + 387) * ((388 - 389) + (390 * 391))",
            "392 - ((393 / (394 + 395)) * (396 - (397 * 2)))",
            "(398 + (399 * (400 - (401 / (402 + 4))))) * 5",
            "403 * ((404 / 405) + (406 - (407 / 3)))",
            "((408 + 409) - 410) * ((411 / 412) + 413)",
            "414 - ((415 + (416 * (417 - 418))) / (419 + 420))",
            "(421 * (422 + (423 / (424 - 2)))) - 425",
            "426 + ((427 - 428) * (429 + (430 / (431 * 3))))",
            "((432 / 4) + 433) * ((434 - 435) + (436 * 437))",
            "438 - ((439 / (440 + 441)) * (442 - (443 * 2)))",
            "(444 + (445 * (446 - (447 / (448 + 4))))) * 5",
            "449 * ((450 / 451) + (452 - (453 / 3)))",
            "((454 + 455) - 456) * ((457 / 458) + 459)",
    };

    private static double getStringExprResult(String expr) {
        Expression expression = new ExpressionBuilder(expr).build();
        return expression.evaluate();
    }

    public static void run(Class<?> parser) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        if (Arrays.stream(parser.getMethods()).anyMatch(x -> x.getName().equals("parse"))) {
            int success = 0;
            ArrayList<Integer> failedTests = new ArrayList<>();
            StringBuilder offset = new StringBuilder().append("   ");
            for (int i = 0; i < tests.length; i++) {
                System.out.printf("%s) %sTest:%s   %s%n", i, RED, RESET, tests[i]);
                double expected = getStringExprResult(tests[i]);
                //TODO: мой парсер для проверки калькулятора
                Object actual = parser.getMethod("parse", String.class).invoke(
                        parser.getDeclaredConstructor().newInstance(), tests[i]);
                if (String.valueOf(i).length() > String.valueOf(i - 1).length()) {
                    offset.append(" ");
                }
                System.out.printf("%s%sExpected result:%s %s%n", offset, GREEN, RESET, expected);
                System.out.printf("%s%sActual result:  %s %s%n%n", offset, GREEN, RESET, actual);
                if (expected == (double) actual) {
                    success++;
                    continue;
                }
                failedTests.add(i);
            }
            System.out.println("_________________________________________________________________");
            System.out.printf("Test count = %s; %sSuccess tests =%s %s; %sTests failed =%s %s;%n",
                    tests.length, GREEN, RESET, success, RED, RESET, tests.length - success);
            System.out.println("_________________________________________________________________");
            if (success == tests.length) {
                System.out.println("Ok!");
            } else {
                System.out.print("Failed tests indexes: ");
                for (int index: failedTests) {
                    System.out.print(index + ", ");
                }
            }
        } else {
            throw new RuntimeException("Wrong parser class, it suppose to have \"parser\" method!");
        }
    }
}
