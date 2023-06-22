create table item_types(type_name varchar(50) constraint  item_type_name_PK primary key,
                        charge_by varchar(50) not null,
                        unit_price numeric(10,2) not null,
                        valid_from date,
                        valid_until date);
COMMENT ON COLUMN item_types.type_name    IS '{"aleas":"ID","comment":"Table PK"}';
COMMENT ON COLUMN item_types.charge_by    IS '{"aleas":"ChargeBy","comment":"Charge by which parameter."}';
COMMENT ON COLUMN item_types.unit_price   IS '{"aleas":"UnitPrice","comment":"The price per charge parameter unit"}';


create table items(item_id serial constraint  item_id_PK primary key,
                                        item_type varchar(50) not null,
                                        is_billable char(1) not null default 'N',--only one item in the hierarchi MUST be chargable
                                        item_props json,
                                        label varchar(50) not null,
                                        constraint item_type_fk foreign key(item_type) references item_types(type_name)
                                        );
                                        
create table item_hierarchy(item_hierarchy_id serial constraint  item_hierarchy_id_PK primary key,
			    item_id integer not null,
                            parent_item_id integer not null,
                            valid_from date not null,
                            valid_until date not null,
                            constraint item_hierarchy_item_id_fk foreign key(item_id) references items(item_id),
                            constraint item_hierarchy_parent_fk foreign key(parent_item_id) references item_hierarchy(item_hierarchy_id)
                           );

create table sec_accounts (username varchar(100),password varchar(30));


insert into sec_accounts values('qqq','qqq');