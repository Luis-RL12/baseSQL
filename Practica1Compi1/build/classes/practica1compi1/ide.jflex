package practica1compi1;
import java_cup.runtime.Symbol;
%%//Separador de area

%class IDELexico
%cup
%cupdebug
%line
%column

/*Identificadores*/
Letra = [a-zA-Z]
Signo = [-_@+*#]
Numero = [0123456789]
%{
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type,Object value){
         return new Symbol(type, yyline, yycolumn, value);
    }
%}
%%//Separador de area.

<YYINITIAL> {
        ("<")     { /*System.out.println("Token: MENOR_QUE con lexema: "+yytext());*/  return symbol(sym.MENOR_QUE);}
        (">")     { /*System.out.println("Token: MAYOR_QUE con lexema: "+yytext());*/ return symbol(sym.MAYOR_QUE);}
        (PROYECTO)  { /*System.out.println("Token: PROYECTO con lexema: "+yytext());*/ return symbol(sym.PROYECTO);}
        (ARCHIVO)   { /*System.out.println("Token: ARCHIVO con lexema: "+yytext());*/ return symbol(sym.ARCHIVO);}
        (CARPETA)   { /*System.out.println("Token: CARPETA con lexema: "+yytext());*/ return symbol(sym.CARPETA);}
        (ubicacion) { /*System.out.println("Token: UBICACION con lexema: "+yytext());*/ return symbol(sym.UBICACION);}
       (nombre)    { /*System.out.println("Token: NOMBRE con lexema: "+yytext());*/ return symbol(sym.NOMBRE);}
        ("<=")     { /*System.out.println("Token: MENOR_IGUAL con lexema: "+yytext());*/  return symbol(sym.MENOR_IGUAL);}
        (">=")     { /*System.out.println("Token: MAYOR_IGUAL con lexema: "+yytext());*/ return symbol(sym.MAYOR_IGUAL);}
        ("<>")     { /*System.out.println("Token: DIFERENTE con lexema: "+yytext());*/ return symbol(sym.DIFERENTE);}
        (SELECCIONAR)  { /*System.out.println("Token: SELECCIONAR con lexema: "+yytext());*/ return symbol(sym.SELECCIONAR);}
        (FILTRAR)   { /*System.out.println("Token: FILTRAR con lexema: "+yytext());*/ return symbol(sym.FILTRAR);}
        (INSERTAR)   { /*System.out.println("Token: INSERTAR con lexema: "+yytext());*/ return symbol(sym.INSERTAR);}
        (ACTUALIZAR) { /*System.out.println("Token: ACTUALIZAR con lexema: "+yytext());*/ return symbol(sym.ACTUALIZAR);}
        (ASIGNAR) { /*System.out.println("Token: ASIGANAR con lexema: "+yytext());*/ return symbol(sym.ASIGNAR);}
         (VALORES) { /*System.out.println("Token: VALORES con lexema: "+yytext());*/ return symbol(sym.VALORES);}
        (ELIMINAR) { /*System.out.println("Token: ELIMINAR con lexema: "+yytext());*/ return symbol(sym.ELIMINAR);}
        (EN) { /*System.out.println("Token: EN con lexema: "+yytext());*/ return symbol(sym.EN);}
       (AND)    { /*System.out.println("Token: AND con lexema: "+yytext());*/ return symbol(sym.AND);}
       (OR)    { /*System.out.println("Token: OR con lexema: "+yytext());*/ return symbol(sym.OR);}
       (sql>)    { /*System.out.println("Token: SQL con lexema: "+yytext()); return symbol(sym.SQL);*/}
        ("=")         { /*System.out.println("Token: IGUAL con lexema: "+yytext());*/ return symbol(sym.IGUAL);}
        ("\"")        { /*System.out.println("Token: COMILLAS con lexema: "+yytext());*/ return symbol(sym.COMILLAS);}
        ("(")        { /*System.out.println("Token: PABIERTO con lexema: "+yytext());*/ return symbol(sym.PABIERTO);}
        (")")        { /*System.out.println("Token: PCERRADO con lexema: "+yytext());*/ return symbol(sym.PCERRADO);}
        (",")        { /*System.out.println("Token: COMA con lexema: "+yytext());*/ return symbol(sym.COMA);}
        (" ")+          { /*System.out.println("Token: ESPACIO con lexema: "+yytext()); return symbol(sym.ESPACIO);*/}
        ("\n")+         { /*System.out.println("Token: SALTO_LINEA con lexema: "+yytext()); return symbol(sym.SALTO_LINEA);*/}
        ("\t")+         {/*Ignorar*/}
            (";")        { /*System.out.println("Token: PUNTOYCOMA con lexema: "+yytext());*/ return symbol(sym.PUNTOYCOMA);}
        ("*")        { /*System.out.println("Token: POR con lexema: "+yytext());*/ return symbol(sym.POR);}    
        ({Letra}|{Signo}|{Numero})({Letra}|{Numero}|{Signo})*   { /*System.out.println("Token: IDNOMBRE con lexema: "+yytext());*/ return symbol(sym.IDNOMBRE, new String(yytext()));}
         (".")        { /*System.out.println("Token: PUNTO con lexema: "+yytext());*/ return symbol(sym.PUNTO);}
        ("/")         { /*System.out.println("Token: DIAGONAL con lexema: "+yytext());*/ return symbol(sym.DIAGONAL);}
        (.csv)      { /*System.out.println("Token: EXTENSION_CSV con lexema: "+yytext());*/ return symbol(sym.EXTENSION_CSV);}
        .           { System.out.println("ERROR LEXICO con lexema: "+yytext()); return symbol(sym.ERROR, new String(yytext()));}
}