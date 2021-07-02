package pe.regioncusco.ivcumbre.common;

import java.util.List;

public class Utils {
    public static Tpl tpl(boolean success, List<?> list, int total){
        return new Tpl(success, list, total);
    }

    public static Tpl tpl(boolean success, String message, List<?> list, int total){
        return new Tpl(success, message, list, total);
    }

    public static Tpl tpl(boolean success, String message){
        return new Tpl(success, message);
    }
}
