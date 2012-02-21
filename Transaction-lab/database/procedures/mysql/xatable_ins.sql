use labs;
drop procedure if exists xatable_ins;

delimiter //
create procedure xatable_ins(in p_id int, in p_message text)
begin
    insert into xatable (id,message) values (p_id,p_message);
end //

delimiter ;