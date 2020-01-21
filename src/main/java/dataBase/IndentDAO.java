package dataBase;

import pojo.Goods;
import pojo.Indent;

import java.util.List;

public interface IndentDAO {
    boolean createIndent (Indent indent);
    boolean updateIndent (Indent indent);
    Indent getIndent (Long idUser); //return array?
    List<Goods> getCartList (Long idUser);
}
