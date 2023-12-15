-- Table: public.satellite

-- DROP TABLE IF EXISTS public.satellite;

CREATE TABLE IF NOT EXISTS public.satellite
(
    id integer NOT NULL DEFAULT nextval('satellite_id_seq'::regclass),
--    image_path character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT satellite_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.satellite
    OWNER to postgres;