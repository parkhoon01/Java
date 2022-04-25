-- INSERT(1111,'홍길동',10)
INSERT INTO sawon (
    empno,
    ename,
    hiredate,
    deptno
) VALUES (
    :v0,
    :v1,
    sysdate,
    :v3
);
COMMIT;

-- DELETE
DELETE FROM sawon
WHERE empno = :v0;

-- UPDATE
UPDATE sawon
SET ename = :v1,
    hiredate = SYSDATE,
    deptno = :v3
WHERE empno = :v0
;

-- SELECTOne
SELECT  empno,
        ename,
        TO_CHAR(hiredate,'YYYY/MM/DD HH24:MI:SS') AS hiredate,
        deptno
FROM sawon
WHERE empno = :v0
;
ROLLBACK;