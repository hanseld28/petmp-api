CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

SET default_tablespace = '';
SET default_with_oids = false;

CREATE TABLE public._foods
(
	foo_id bigint NOT NULL,
  	foo_name character varying(255)
);

CREATE SEQUENCE public._seq_foo_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public._seq_foo_id OWNED BY public._foods.foo_id;


CREATE TABLE public._pets
(
	pet_id bigint NOT NULL,
	pet_name character varying(255)
  	
);


CREATE SEQUENCE public._seq_pet_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public._seq_pet_id OWNED BY public._pets.pet_id;

CREATE TABLE public._weekly_meal_plans
(
  wmp_id bigint NOT NULL,
  wmp_description character varying(255),
  wmp_meal_type character varying(255),
  wmp_title character varying(255),
  wmp_friday_meal_id bigint,
  wmp_monday_meal_id bigint,
  wmp_saturday_meal_id bigint,
  wmp_sunday_meal_id bigint,
  wmp_thursday_meal_id bigint,
  wmp_tuesday_meal_id bigint,
  wmp_wednesday_meal_id bigint,
  wmp_created_on timestamp without time zone
);

CREATE SEQUENCE public._seq_wmp_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public._seq_wmp_id OWNED BY public._weekly_meal_plans.wmp_id;


CREATE TABLE public._weekly_meal_plan_pets
(
  wpt_wmp_id bigint NOT NULL,
  wpt_pet_id bigint NOT NULL
);


ALTER TABLE ONLY public._foods ALTER COLUMN foo_id SET DEFAULT nextval('public._seq_foo_id'::regclass);


ALTER TABLE ONLY public._pets ALTER COLUMN pet_id SET DEFAULT nextval('public._seq_pet_id'::regclass);


ALTER TABLE ONLY public._weekly_meal_plans ALTER COLUMN wmp_id SET DEFAULT nextval('public._seq_wmp_id'::regclass);



ALTER TABLE ONLY public._foods
    ADD CONSTRAINT _foo_pk PRIMARY KEY (foo_id);

ALTER TABLE ONLY public._pets
    ADD CONSTRAINT _pet_pk PRIMARY KEY (pet_id);
    
ALTER TABLE ONLY public._weekly_meal_plans
    ADD CONSTRAINT _wmp_pk PRIMARY KEY (wmp_id);
    
ALTER TABLE ONLY public._weekly_meal_plan_pets
    ADD CONSTRAINT _wpt_pk PRIMARY KEY (wpt_wmp_id, wpt_pet_id);    


CREATE INDEX ind_foo_name ON public._foods USING btree (foo_name);

CREATE INDEX ind_pet_name ON public._pets USING btree (pet_name);

CREATE INDEX ind_wmp_title ON public._weekly_meal_plans USING btree (wmp_title);

CREATE INDEX ind_wmp_meal_type ON public._weekly_meal_plans USING btree (wmp_meal_type);



ALTER TABLE ONLY public._weekly_meal_plans
    ADD CONSTRAINT _wmp_saturday_meal_fk FOREIGN KEY (wmp_saturday_meal_id) REFERENCES public._foods(foo_id);

ALTER TABLE ONLY public._weekly_meal_plans
    ADD CONSTRAINT _wmp_friday_meal_fk FOREIGN KEY (wmp_friday_meal_id) REFERENCES public._foods(foo_id);

ALTER TABLE ONLY public._weekly_meal_plans
    ADD CONSTRAINT _wmp_thursday_meal_fk FOREIGN KEY (wmp_thursday_meal_id) REFERENCES public._foods(foo_id);

ALTER TABLE ONLY public._weekly_meal_plans
    ADD CONSTRAINT _wmp_tuesday_meal_fk FOREIGN KEY (wmp_tuesday_meal_id) REFERENCES public._foods(foo_id);

ALTER TABLE ONLY public._weekly_meal_plans
    ADD CONSTRAINT _wmp_wednesday_meal_fk FOREIGN KEY (wmp_wednesday_meal_id) REFERENCES public._foods(foo_id);

ALTER TABLE ONLY public._weekly_meal_plans
    ADD CONSTRAINT _wmp_monday_meal_fk FOREIGN KEY (wmp_monday_meal_id) REFERENCES public._foods(foo_id);

ALTER TABLE ONLY public._weekly_meal_plans
    ADD CONSTRAINT _wmp_sunday_meal_fk FOREIGN KEY (wmp_sunday_meal_id) REFERENCES public._foods(foo_id);

      
ALTER TABLE ONLY public._weekly_meal_plan_pets
    ADD CONSTRAINT _wpt_wmp_fk FOREIGN KEY (wpt_wmp_id) REFERENCES public._weekly_meal_plans(wmp_id);

ALTER TABLE ONLY public._weekly_meal_plan_pets
    ADD CONSTRAINT _wpt_pet_fk FOREIGN KEY (wpt_pet_id) REFERENCES public._pets(pet_id);
    
