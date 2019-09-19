create table comment (comment_id integer not null auto_increment, comment_content varchar(255), comment_heading varchar(255), review_review_id integer, primary key (comment_id));
create table product (product_id integer not null auto_increment, product_description varchar(255), product_name varchar(255), product_price double precision not null, primary key (product_id));
create table review (review_id integer not null auto_increment, review_content varchar(255), review_heading varchar(255), product_product_id integer, primary key (review_id)) ;
