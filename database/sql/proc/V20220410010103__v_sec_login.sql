CREATE OR REPLACE FUNCTION sec_login(p_sessionid varchar/*not used*/, p_username varchar, p_password varchar) 
RETURNS text AS
$$
DECLARE
	v_sessionid char(32):=null;
BEGIN
    --RETURN QUERY  SELECT row_to_json(a) FROM (SELECT username, password FROM sec_accounts) a;
	select md5(random()::text) into v_sessionid from sec_accounts a where a.username=p_username and a.password=p_password;
	if v_sessionid is not null
	then --TO DO Insert into sessions
		return '{"responce":"OK","message":"login succeed.","data":{"sessionid":"'||v_sessionid||'"}}';
	else 
		return '{"responce":"ERROR","message":"Invalid user/password"}' ;
   end if;
END;
$$ LANGUAGE plpgsql;