CREATE VIEW ALL_LITERALS_VIEW (ID,VALUE,MODIFIER_ID,REF) AS
	SELECT
		L.ID,L.VALUE,L.MODIFIER_ID,L.REF
	FROM
		ANZO_L L
	WHERE
		L.REF=0
UNION
	SELECT
		TL.ID,TL.VALUE,TL.MODIFIER_ID,TL.REF
	FROM
		ANZO_TL TL
	WHERE
		TL.REF=0;