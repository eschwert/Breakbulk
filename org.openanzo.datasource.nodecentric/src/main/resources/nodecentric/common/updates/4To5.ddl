CREATE TABLE {0}_TL (
    ID          {6} NOT NULL,
    VALUE       {7}({4}) {3},
    MODIFIER_ID	{6}  NOT NULL,
	REF			{6} NOT NULL,
    PRIMARY KEY(ID)
)  {2};
#Index for _TL table
CREATE UNIQUE INDEX {0}_TL_V ON {0}_TL(VALUE,MODIFIER_ID);
CREATE INDEX {0}_TL_RI ON {0}_TL(REF,ID);

CREATE TABLE {0}_LTL (
	ID			{6} NOT NULL,
	HASH		{6} NOT NULL,
	VALUE		{8},
	MODIFIER_ID	{6},
	REF			{6} NOT NULL,
	PRIMARY KEY	(ID)
) {2};
#Index for _LTL table
CREATE INDEX {0}_LTL_V ON {0}_LTL(HASH,MODIFIER_ID);
CREATE INDEX {0}_LTL_RI ON {0}_LTL(REF,ID);


CREATE TABLE {0}_DATATYPE (
	ID			{9},
	VALUE		{7}({4}) {3},
	PRIMARY KEY(ID)
)  {2} ;

CREATE TABLE {0}_LANGUAGE (
	ID			{9},
	VALUE		{7}({4}) {3},
	PRIMARY KEY(ID)
)  {2};

INSERT INTO {0}_TL(ID,VALUE,MODIFIER_ID,REF) SELECT ID,VALUE,MODIFIER_ID,REF FROM {0}_L WHERE ID >= 4611686018427387905 AND ID < 5764607523034234879;
DELETE FROM {0}_L WHERE ID >= 4611686018427387905 AND ID < 5764607523034234879;

INSERT INTO {0}_LTL(ID,HASH,VALUE,MODIFIER_ID,REF) SELECT ID,HASH,VALUE,MODIFIER_ID,REF FROM {0}_LL WHERE ID >= 5764607523034234881 AND ID < 6917529027641081855; 
DELETE FROM {0}_LL WHERE ID >=  5764607523034234881 AND MODIFIER_ID < 6917529027641081855;

INSERT INTO {0}_DATATYPE (VALUE) SELECT VALUE FROM LIT_DATATYPE;
INSERT INTO {0}_LANGUAGE (VALUE) SELECT VALUE FROM LIT_LANGUAGE;

UPDATE {0}_L SET MODIFIER_ID=(SELECT {0}_LANGUAGE.ID FROM {0}_LANGUAGE,LIT_LANGUAGE WHERE {0}_LANGUAGE.VALUE=LIT_LANGUAGE.VALUE AND LIT_LANGUAGE.ID=MODIFIER_ID) WHERE MODIFIER_ID !=0;
UPDATE {0}_LL SET MODIFIER_ID=(SELECT {0}_LANGUAGE.ID FROM {0}_LANGUAGE,LIT_LANGUAGE WHERE {0}_LANGUAGE.VALUE=LIT_LANGUAGE.VALUE AND LIT_LANGUAGE.ID=MODIFIER_ID) WHERE MODIFIER_ID !=0;
UPDATE {0}_TL SET MODIFIER_ID=(SELECT {0}_DATATYPE.ID FROM {0}_DATATYPE,LIT_DATATYPE WHERE {0}_DATATYPE.VALUE=LIT_DATATYPE.VALUE AND LIT_DATATYPE.ID=MODIFIER_ID) WHERE MODIFIER_ID !=0;
UPDATE {0}_LTL SET MODIFIER_ID=(SELECT {0}_DATATYPE.ID FROM {0}_DATATYPE,LIT_DATATYPE WHERE {0}_DATATYPE.VALUE=LIT_DATATYPE.VALUE AND LIT_DATATYPE.ID=MODIFIER_ID) WHERE MODIFIER_ID !=0;

DROP TABLE LIT_DATATYPE;
DROP TABLE LIT_LANGUAGE;

DROP SEQUENCE NODE_SEQ_7;
DROP SEQUENCE NODE_SEQ_8;
DROP SEQUENCE NODE_SEQ_9;
DROP SEQUENCE TRANSACTION_SEQ;
DROP SEQUENCE STMT_REV_SEQ;
