--网厅
--新增，门店所对应的省市区  格式：四川省-南充市-仪陇县
alter table eb_shipper_address add ebsa_dept_district varchar(100)

--创建理赔表id序列
create sequence ei_customer_claim_id_seq increment by 1 minvalue 1 no maxvalue start with 1;     			
--创建理赔表
create  table ei_customer_claim(
   id numeric primary key  not null default nextval('ei_customer_claim_id_seq'),
   ebccId numeric,
   billNo varchar(32),
   claimParty  varchar(32),
   billTel  varchar(32),
   claimCompanyAddr  varchar(200),
   isEntrust varchar(32),
   contactName varchar(200),
   contactTel varchar(32),
   contactMail varchar(50),
   claimsAmount numeric, 
   cargoType varchar(50),
   exceptionCount numeric,
   accidentType varchar(32),
   reason varchar(2000),
   status varchar(32),
   imgMapString varchar(4000),
   createTime timestamp,
   modifytime timestamp
);
--官网