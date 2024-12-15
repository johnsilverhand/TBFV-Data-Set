import java.util.*;
import java.util.regex.Pattern;

public class TestHome2DBackground {
    private static final String PATH_PATTERN = "^(?:[a-zA-Z]:\\\\(?:[^<>:\"/\\\\|?*\\r\\n]+\\\\?)*|/[^<>:\"|?*\\r\\n]+(/[^<>:\"|?*\\r\\n]*)*\\/?)$";

    public static Object testHome2DBackground(String key, Integer type, String backgroundList, String backgroundSpeedList, 
                                              String deviation, String horizonY, String nightBackgroundList, 
                                              String nightBackgroundSpeedList, String unnamed) {
        List<String> errorList = new ArrayList<>();
        String passMsg = "pass";

        // 未导表直接返回 pass
        if (!"是".equals(unnamed)) {
            return passMsg;
        }

        // 检查背景类型
        if (type == null) {
            errorList.add(key + " 的Type未填");
        } else if (type != 1 || type != 2) { //wrong code
            errorList.add(key + " 的Type填写错误");
        }

        // 检查背景资源列表
        if (backgroundList == null) {
            errorList.add(key + " 的背景资源路径错误");
        } else {
            String[] backgroundPathList = backgroundList.split(";");
            for (String backgroundPath : backgroundPathList) {
                if (!isValidPath(backgroundPath)) {
                    if (backgroundPath.contains(":")) {
                        String[] randomPaths = backgroundPath.split(":");
                        for (String randomPath : randomPaths) {
                            if (!isValidPath(randomPath)) {
                                errorList.add(key + " 的背景资源路径不存在: " + randomPath);
                            }
                        }
                    } else {
                        errorList.add(key + " 的背景资源路径不存在: " + backgroundPath);
                    }
                }
            }
        }

        // 检查人物图片偏移
        if (deviation != null) {
            String[] deviationList = deviation.split(",");
            if (deviationList.length != 2) {
                errorList.add(key + " 的人物图片偏移填写错误");
            } else {
                for (String value : deviationList) {
                    try {
                        Float.parseFloat(value);
                    } catch (NumberFormatException e) {
                        errorList.add(key + " 的人物图片偏移填写错误");
                    }
                }
            }
        }

        // 地上背景类型的特定检查
        if (type != null && type == 1) {
            // 检查地平线值
            if (horizonY == null) {
                errorList.add(key + " 的Horizony未填");
            } else {
                try {
                    Integer.parseInt(horizonY);
                } catch (NumberFormatException e) {
                    errorList.add(key + " 的Horizony填写错误");
                }
            }

            // 检查黑夜背景资源列表
            if (nightBackgroundList == null) {
                errorList.add(key + " 的黑夜背景资源路径错误");
            } else {
                String[] nightBackgroundPaths = nightBackgroundList.split(";");
                for (String nightBackgroundPath : nightBackgroundPaths) {
                    if (!isValidPath(nightBackgroundPath)) {
                        if (nightBackgroundPath.contains(":")) {
                            String[] randomPaths = nightBackgroundPath.split(":");
                            for (String randomPath : randomPaths) {
                                if (!isValidPath(randomPath)) {
                                    errorList.add(key + " 的黑夜背景资源路径不存在: " + randomPath);
                                }
                            }
                        } else {
                            errorList.add(key + " 的黑夜背景资源路径不存在: " + nightBackgroundPath);
                        }
                    }
                }
            }

            // 检查黑夜背景速度比例
            if (nightBackgroundSpeedList == null) {
                errorList.add(key + " 的黑夜背景移动速度比例未填写全");
            } else {
                String[] nightSpeeds = nightBackgroundSpeedList.split(";");
                if (nightBackgroundList != null && nightSpeeds.length != nightBackgroundList.split(";").length) {
                    errorList.add(key + " 的黑夜背景移动速度比例未填写全");
                } else {
                    for (String speedGroup : nightSpeeds) {
                        String[] speeds = speedGroup.split(",");
                        if (speeds.length != 2) {
                            errorList.add(key + " 的黑夜背景移动速度比例填写错误");
                        } else {
                            for (String speed : speeds) {
                                try {
                                    Float.parseFloat(speed);
                                } catch (NumberFormatException e) {
                                    errorList.add(key + " 的黑夜背景移动速度比例填写错误");
                                }
                            }
                        }
                    }
                }
            }
        }

        // 检查背景速度比例
        if (backgroundSpeedList == null) {
            errorList.add(key + " 的背景移动速度比例未填写全");
        } else {
            String[] backgroundSpeeds = backgroundSpeedList.split(";");
            if (backgroundList != null && backgroundSpeeds.length != backgroundList.split(";").length) {
                errorList.add(key + " 的背景移动速度比例未填写全");
            } else {
                for (String speedGroup : backgroundSpeeds) {
                    String[] speeds = speedGroup.split(",");
                    if (speeds.length != 2) {
                        errorList.add(key + " 的背景移动速度比例填写错误");
                    } else {
                        for (String speed : speeds) {
                            try {
                                Float.parseFloat(speed);
                            } catch (NumberFormatException e) {
                                errorList.add(key + " 的背景移动速度比例填写错误");
                            }
                        }
                    }
                }
            }
        }

        // 返回结果
        return errorList.isEmpty() ? passMsg : errorList;
    }

    // 检查路径格式
    private static boolean isValidPath(String path) {
        return Pattern.matches(PATH_PATTERN, path);
    }

    public static void main(String[] args) {
        // 示例测试
        System.out.println(testHome2DBackground("key1", 1, "path1;path2", "0.3,0.3;0.6,0.6", "10,10", "100", "nightpath1", "0.1,0.1", "是"));
        System.out.println(testHome2DBackground("key2", null, null, null, "10", null, null, null, "是"));
    }
}
