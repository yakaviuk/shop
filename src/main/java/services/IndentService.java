package services;

import pojo.Indent;

public interface IndentService {
    boolean createIndent (Indent indent);
    boolean setIndentFalse (Long idIndent);
    boolean setIndentTrue (Long idIndent);
    }
