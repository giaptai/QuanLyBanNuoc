
package BLL;

import DAL.CSDLQueryDao;
import DTO.sanphamdao;

public class CheckDao {
    public static boolean CheckThem(sanphamdao dao) {
        return CSDLQueryDao.ThemSP(dao);
    }
    
    public static boolean CheckSua(sanphamdao dao) {
        return CSDLQueryDao.SuaSP(dao);
    }
    
    public static boolean CheckXoa(sanphamdao dao) {
        return CSDLQueryDao.XoaSP(dao);
    }
}
