-- Table: public.image_request

-- DROP TABLE IF EXISTS public.image_request;

CREATE TABLE IF NOT EXISTS public.image_request
(
    id SERIAL PRIMARY KEY,
    satellite_id bigint REFERENCES public.satellite(id) NOT NULL,
	status VARCHAR(225) NOT NULL,
--    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT image_request_fk FOREIGN KEY (satellite_id) REFERENCES public.satellite(id)
);

ALTER TABLE IF EXISTS public.image_request
    OWNER to postgres;
