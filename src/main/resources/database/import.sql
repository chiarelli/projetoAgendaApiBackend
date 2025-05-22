-- CREATE EXTENSION IF NOT EXISTS "pgcrypto";

INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Familia');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Trabalho');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Amigos');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Estudo');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Lazer');
INSERT INTO public.tb_categoria(id, nome) VALUES (gen_random_uuid(), 'Outros');