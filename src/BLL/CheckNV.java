
package BLL;

import DAL.CSDLQueryNV;
import DTO.nhanviendao;

public class CheckNV {
      public static boolean CheckThem(nhanviendao dao) {
        return CSDLQueryNV.ThemNV(dao);
    }
    
    public static boolean CheckSua(nhanviendao dao) {
        return CSDLQueryNV.SuaNV(dao);
    }
    
    public static boolean CheckXoa(nhanviendao dao) {
        return CSDLQueryNV.XoaNV(dao);
    }
}
