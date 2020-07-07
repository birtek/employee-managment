package pl.szydlowski.springbootcrudapi.service;

class ServiceUtils {
    static int checkCorrectPage(int page){
        return page > 0 ? page : 1;
    }
}
