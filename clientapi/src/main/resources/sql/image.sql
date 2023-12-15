-- Table: public.image

-- DROP TABLE IF EXISTS public.image;

CREATE TABLE IF NOT EXISTS public.image
(
    id SERIAL PRIMARY KEY,
    satellite_id bigint REFERENCES public.satellite(id) NOT NULL,
	image_request_id bigint REFERENCES public.image_request(id) NOT NULL,
	image_path VARCHAR(225) NOT NULL,
--    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT satellite_fk FOREIGN KEY (satellite_id) REFERENCES public.satellite(id),
    CONSTRAINT image_request_fk FOREIGN KEY (image_request_id) REFERENCES public.image_request(id)

);

ALTER TABLE IF EXISTS public.image_request
    OWNER to postgres;
