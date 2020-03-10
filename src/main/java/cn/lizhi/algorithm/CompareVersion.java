package cn.lizhi.algorithm;

/**
 * 比较版本号大小
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月15日
 */
public class CompareVersion {
    public static void main(String[] args) {
        String version1 = "01";
        String version2 = "1";
        System.out.println(compareVersion(version1, version2));
    }
    
    private static int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.", -1);
        String[] versions2 = version2.split("\\.", -1);
        
        for (int i = 0; i < Math.max(versions1.length, versions2.length); i++) {
            int v1 = i < versions1.length ? Integer.parseInt(versions1[i]) : 0;
            int v2 = i < versions2.length ? Integer.parseInt(versions2[i]) : 0;
            
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        
        return 0;
    }
}
