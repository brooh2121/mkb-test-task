create table CAR (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  power DOUBLE,
  year_of_issue YEAR/*,
  assessed_value DEC(20)*/
);

create table AIRPLANE (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  manufacturer VARCHAR2(500),
  year_of_issue YEAR,
  fuelCapacity INT,
  seats INT/*,
  assessed_value DEC(20)*/-- отсебятина
);

create table ASSESSMENT (
    assessment_id IDENTITY primary key,
    assessed_value DEC(20),
    assessment_date timestamp default CURRENT_TIMESTAMP,
    id bigint,
    foreign key (id) references car(id)/*,
    foreign key (id) references AIRPLANE (id)*/
)