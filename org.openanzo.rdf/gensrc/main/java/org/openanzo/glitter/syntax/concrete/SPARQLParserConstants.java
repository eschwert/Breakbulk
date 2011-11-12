/* Generated By:JavaCC: Do not edit this line. SPARQLParserConstants.java */
/******************************************************************************* 
 * Copyright (c) 2004, 2007-2009 IBM Corporation and Cambridge Semantics Incorporated. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/grammar/sparql.jj,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: sparql.jj 164 2007-07-31 14:11:09Z mroy $ 
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 * Cambridge Semantics Incorporated - Fork to Anzo 
 *******************************************************************************/
package org.openanzo.glitter.syntax.concrete;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface SPARQLParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int COMMENT = 6;
  /** RegularExpression Id. */
  int BASE = 7;
  /** RegularExpression Id. */
  int PREFIX = 8;
  /** RegularExpression Id. */
  int SELECT = 9;
  /** RegularExpression Id. */
  int DISTINCT = 10;
  /** RegularExpression Id. */
  int REDUCED = 11;
  /** RegularExpression Id. */
  int COUNT = 12;
  /** RegularExpression Id. */
  int AVG = 13;
  /** RegularExpression Id. */
  int SAMPLE = 14;
  /** RegularExpression Id. */
  int SUM = 15;
  /** RegularExpression Id. */
  int MIN = 16;
  /** RegularExpression Id. */
  int MAX = 17;
  /** RegularExpression Id. */
  int GROUP_CONCAT = 18;
  /** RegularExpression Id. */
  int SEPARATOR = 19;
  /** RegularExpression Id. */
  int CONSTRUCT = 20;
  /** RegularExpression Id. */
  int ASK = 21;
  /** RegularExpression Id. */
  int DESCRIBE = 22;
  /** RegularExpression Id. */
  int FROM = 23;
  /** RegularExpression Id. */
  int NAMED = 24;
  /** RegularExpression Id. */
  int DATASET = 25;
  /** RegularExpression Id. */
  int WHERE = 26;
  /** RegularExpression Id. */
  int ORDER = 27;
  /** RegularExpression Id. */
  int BY = 28;
  /** RegularExpression Id. */
  int ASC = 29;
  /** RegularExpression Id. */
  int DESC = 30;
  /** RegularExpression Id. */
  int LIMIT = 31;
  /** RegularExpression Id. */
  int OFFSET = 32;
  /** RegularExpression Id. */
  int OPTIONAL = 33;
  /** RegularExpression Id. */
  int GRAPH = 34;
  /** RegularExpression Id. */
  int UNION = 35;
  /** RegularExpression Id. */
  int FILTER = 36;
  /** RegularExpression Id. */
  int LET = 37;
  /** RegularExpression Id. */
  int GROUP = 38;
  /** RegularExpression Id. */
  int SAMETERM = 39;
  /** RegularExpression Id. */
  int STR = 40;
  /** RegularExpression Id. */
  int LANG = 41;
  /** RegularExpression Id. */
  int LANGMATCHES = 42;
  /** RegularExpression Id. */
  int DATATYPE = 43;
  /** RegularExpression Id. */
  int BOUND = 44;
  /** RegularExpression Id. */
  int ISIRI = 45;
  /** RegularExpression Id. */
  int ISURI = 46;
  /** RegularExpression Id. */
  int ISBLANK = 47;
  /** RegularExpression Id. */
  int ISLITERAL = 48;
  /** RegularExpression Id. */
  int REGEX = 49;
  /** RegularExpression Id. */
  int IN = 50;
  /** RegularExpression Id. */
  int TRUE = 51;
  /** RegularExpression Id. */
  int FALSE = 52;
  /** RegularExpression Id. */
  int AS = 53;
  /** RegularExpression Id. */
  int A = 54;
  /** RegularExpression Id. */
  int STAR = 55;
  /** RegularExpression Id. */
  int DOT = 56;
  /** RegularExpression Id. */
  int LCURLY = 57;
  /** RegularExpression Id. */
  int RCURLY = 58;
  /** RegularExpression Id. */
  int LBRACKET = 59;
  /** RegularExpression Id. */
  int RBRACKET = 60;
  /** RegularExpression Id. */
  int LPAREN = 61;
  /** RegularExpression Id. */
  int RPAREN = 62;
  /** RegularExpression Id. */
  int SEMIC = 63;
  /** RegularExpression Id. */
  int COMMA = 64;
  /** RegularExpression Id. */
  int PLUS = 65;
  /** RegularExpression Id. */
  int MINUS = 66;
  /** RegularExpression Id. */
  int OR = 67;
  /** RegularExpression Id. */
  int AND = 68;
  /** RegularExpression Id. */
  int EQ = 69;
  /** RegularExpression Id. */
  int NE = 70;
  /** RegularExpression Id. */
  int LT = 71;
  /** RegularExpression Id. */
  int LE = 72;
  /** RegularExpression Id. */
  int GT = 73;
  /** RegularExpression Id. */
  int GE = 74;
  /** RegularExpression Id. */
  int SLASH = 75;
  /** RegularExpression Id. */
  int NOT = 76;
  /** RegularExpression Id. */
  int DATATYPEMARKER = 77;
  /** RegularExpression Id. */
  int ASSIGN = 78;
  /** RegularExpression Id. */
  int Q_IRI_REF = 79;
  /** RegularExpression Id. */
  int QNAME_NS = 80;
  /** RegularExpression Id. */
  int QNAME = 81;
  /** RegularExpression Id. */
  int BLANK_NODE_LABEL = 82;
  /** RegularExpression Id. */
  int VAR1 = 83;
  /** RegularExpression Id. */
  int VAR2 = 84;
  /** RegularExpression Id. */
  int LCLETTER = 85;
  /** RegularExpression Id. */
  int UCLETTER = 86;
  /** RegularExpression Id. */
  int LETTER = 87;
  /** RegularExpression Id. */
  int NUMBER = 88;
  /** RegularExpression Id. */
  int ALPHANUM = 89;
  /** RegularExpression Id. */
  int LANGTAG = 90;
  /** RegularExpression Id. */
  int INTEGER = 91;
  /** RegularExpression Id. */
  int DECIMAL = 92;
  /** RegularExpression Id. */
  int DOUBLE = 93;
  /** RegularExpression Id. */
  int EXPONENT = 94;
  /** RegularExpression Id. */
  int STRING_LITERAL1 = 95;
  /** RegularExpression Id. */
  int STRING_LITERAL2 = 96;
  /** RegularExpression Id. */
  int STRING_LITERAL_LONG1 = 97;
  /** RegularExpression Id. */
  int STRING_LITERAL_LONG2 = 98;
  /** RegularExpression Id. */
  int ECHAR = 99;
  /** RegularExpression Id. */
  int HEX = 100;
  /** RegularExpression Id. */
  int NIL = 101;
  /** RegularExpression Id. */
  int WS = 102;
  /** RegularExpression Id. */
  int ANON = 103;
  /** RegularExpression Id. */
  int NCCHAR1P = 104;
  /** RegularExpression Id. */
  int NCCHAR1 = 105;
  /** RegularExpression Id. */
  int VARNAME = 106;
  /** RegularExpression Id. */
  int NCCHAR = 107;
  /** RegularExpression Id. */
  int NCNAME_PREFIX = 108;
  /** RegularExpression Id. */
  int NCNAME = 109;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\f\"",
    "\"\\r\"",
    "\"\\n\"",
    "<COMMENT>",
    "\"base\"",
    "\"prefix\"",
    "\"select\"",
    "\"distinct\"",
    "\"reduced\"",
    "\"count\"",
    "\"avg\"",
    "\"sample\"",
    "\"sum\"",
    "\"min\"",
    "\"max\"",
    "\"group_concat\"",
    "\"separator\"",
    "\"construct\"",
    "\"ask\"",
    "\"describe\"",
    "\"from\"",
    "\"named\"",
    "\"dataset\"",
    "\"where\"",
    "\"order\"",
    "\"by\"",
    "\"asc\"",
    "\"desc\"",
    "\"limit\"",
    "\"offset\"",
    "\"optional\"",
    "\"graph\"",
    "\"union\"",
    "\"filter\"",
    "\"let\"",
    "\"group\"",
    "\"sameterm\"",
    "\"str\"",
    "\"lang\"",
    "\"langmatches\"",
    "\"datatype\"",
    "\"bound\"",
    "\"isiri\"",
    "\"isuri\"",
    "\"isblank\"",
    "\"isliteral\"",
    "\"regex\"",
    "\"in\"",
    "\"true\"",
    "\"false\"",
    "\"as\"",
    "\"a\"",
    "\"*\"",
    "\".\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\"(\"",
    "\")\"",
    "\";\"",
    "\",\"",
    "\"+\"",
    "\"-\"",
    "\"||\"",
    "\"&&\"",
    "\"=\"",
    "\"!=\"",
    "\"<\"",
    "\"<=\"",
    "\">\"",
    "\">=\"",
    "\"/\"",
    "\"!\"",
    "\"^^\"",
    "\":=\"",
    "<Q_IRI_REF>",
    "<QNAME_NS>",
    "<QNAME>",
    "<BLANK_NODE_LABEL>",
    "<VAR1>",
    "<VAR2>",
    "<LCLETTER>",
    "<UCLETTER>",
    "<LETTER>",
    "<NUMBER>",
    "<ALPHANUM>",
    "<LANGTAG>",
    "<INTEGER>",
    "<DECIMAL>",
    "<DOUBLE>",
    "<EXPONENT>",
    "<STRING_LITERAL1>",
    "<STRING_LITERAL2>",
    "<STRING_LITERAL_LONG1>",
    "<STRING_LITERAL_LONG2>",
    "<ECHAR>",
    "<HEX>",
    "<NIL>",
    "<WS>",
    "<ANON>",
    "<NCCHAR1P>",
    "<NCCHAR1>",
    "<VARNAME>",
    "<NCCHAR>",
    "<NCNAME_PREFIX>",
    "<NCNAME>",
  };

}