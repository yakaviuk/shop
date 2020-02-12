package services;

import pojo.Goods;
import pojo.Indent;

import java.util.List;

public interface IndentService {
    boolean createIndent(Indent indent);
    boolean setIndentZero(Long idUser);
    List<Goods> getCartList(Long idUser);
    Double getSum(Long idUser);
}