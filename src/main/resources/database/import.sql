\connect agendaapi;

CREATE TABLE IF NOT EXISTS public.tb_categoria
(
    id uuid NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tb_categoria_pkey PRIMARY KEY (id),
    CONSTRAINT ukat5cf41guxjf4dkdeo5qxva9 UNIQUE (nome)
);

INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Familia');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Trabalho');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Amigos');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Estudo');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Lazer');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Outros');