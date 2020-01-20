package dataBase;

import pojo.Indent;

public interface IndentDAO {
    boolean createIndent (Indent indent);
    boolean updateIndent (Indent indent);
    Indent getIndent (Long idUser); //return array?
}
