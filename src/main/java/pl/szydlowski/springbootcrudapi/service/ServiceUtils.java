package pl.szydlowski.springbootcrudapi.service;

public class ServiceUtils {
    public static int checkCorrectPage(int page){
        return page > 0 ? page : 1;
    }
}
