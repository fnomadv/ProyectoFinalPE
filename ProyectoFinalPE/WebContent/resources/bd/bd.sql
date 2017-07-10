drop database bdproyfinal;
create database bdproyfinal;
use bdproyfinal;

desc tb_producto;
desc tb_pedido;
desc tb_detallepedido;

drop table tb_detallepedido;
drop table tb_pedido;


select * from tb_empleado;
select * from tb_cliente;
select * from tb_pedido;
select * from tb_detallepedido;
select * from tb_cargo;
select * from tb_departamento;
select * from tb_rol;

select * from tb_detallepedido p where p.PEDIDO_ID = 951;

delete from tb_pedido where id=1201;
/* INSERTS TB_DEPARTAMENTO*/
insert into tb_departamento (nombre) values 
('Ventas'),('Soporte');

insert into tb_producto (id,isbn,titulo,imagen,descripcion,precio,stock) values 
(1,'9682535896125','GET SMART 1','/resources/images/getsmart/gs1.jpg','DESCRIPCION DEL LIBRO',19.00,500),
(2,'9682535896222','GET SMART 2','/resources/images/getsmart/gs2.jpg','DESCRIPCION DEL LIBRO',20.00,500),
(3,'9682535896333','GET SMART 3','/resources/images/getsmart/gs3.jpg','DESCRIPCION DEL LIBRO',21.00,500),
(4,'9682535896444','GET SMART 4','/resources/images/getsmart/gs4.jpg','DESCRIPCION DEL LIBRO',22.00,450),
(5,'9682535896555','GET SMART 5','/resources/images/getsmart/gs5.jpg','DESCRIPCION DEL LIBRO',23.00,600),
(6,'9682535896666','GET SMART 6','/resources/images/getsmart/gs6.jpg','DESCRIPCION DEL LIBRO',24.00,700);