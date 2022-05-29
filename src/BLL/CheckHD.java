package BLL;

import DAL.CSDLQueryHD;
import DTO.chitiethoadon;
import DTO.hoadondao;
import java.util.ArrayList;

public class CheckHD {
    public static boolean CheckThem(hoadondao hd, ArrayList<chitiethoadon> ctietsp){
        return CSDLQueryHD.ThemHD(hd, ctietsp);
    }
}
