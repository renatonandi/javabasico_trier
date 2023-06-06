-- 1
select * from cargo;

-- 2
select cidade.nome, cidade.qt_vereadores from cidade order by cidade.nome;

-- 3
select cidade.nome, cidade.qt_vereadores from cidade where qt_vereadores > 9;

-- 4
select count(*) from cidade where qt_vereadores > 9; 

-- 5
select max(qt_vereadores) from cidade;

-- 6
select cidade.nome from cidade where cidade.qt_vereadores = (select max(qt_vereadores) from cidade);

-- 7
select candidato.nome from candidato inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito' order by candidato.nome;

-- 8
select c.nome from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' where c.nome like '%MARIA%' order by c.nome;

-- 9
select c.nome from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' where c.nome like 'Y%' order by c.nome;

-- 10
select c.nome as candidatos, ci.nome as cidades from candidato c 
inner join cidade ci on ci.id = c.cidade 
inner join cargo ca on ca.id = c.cargo and ca.nome = 'Prefeito'order by ci.nome, c.nome;

-- 11
select c.nome from candidato c 
inner join cidade ci on ci.id = c.cidade 
inner join cargo ca on ca.id = c.cargo  and ca.nome = 'Prefeito' and ci.nome = 'TUBARÃO' order by c.nome;

-- 12
select c.nome from candidato c inner join cidade ci on ci.id = c.cidade inner join cargo ca on ca.id = c.cargo  and ca.nome = 'Prefeito' and ci.qt_eleitores = (select max(qt_eleitores) from cidade);

-- 13
select count(*) from candidato c inner join cidade ci on ci.id = c.cidade inner join cargo ca on ca.id = c.cargo and ci.nome = 'TUBARÃO' and ca.nome = 'Vereador';

-- 14
select (select count(*) from candidato ), ci.nome from candidato c inner join cidade ci on ci.id = c.cidade inner join cargo ca on ca.id = c.cargo and ca.nome = 'Vereador';

-- 15
select sum(vi.brancos) as brancos, sum(vi.nulos) as nulos from voto_invalido vi inner join cidade ci on ci.id = vi.cidade and ci.nome = 'TUBARÃO';

-- 16
select sum(vi.nulos + vi.brancos) from voto_invalido vi inner join cidade ci ON ci.id = vi.cidade inner join cargo ca on ca.id = vi.cargo and ci.nome = 'TUBARÃO' and ca.nome = 'Prefeito'; 

-- 17
select c.nome, v.voto from voto v 
inner join candidato c on c.id = v.candidato 
inner join cidade ci on ci.id = c.cidade 
inner join cargo ca on ca.id = c.cargo and ca.nome = 'Prefeito' and ci.nome = 'TUBARÃO' order by v.voto desc;

-- 18
select c.nome, v.voto from voto v 
inner join candidato c on c.id = v.candidato 
inner join cidade ci on ci.id = c.cidade 
inner join cargo ca on ca.id = c.cargo and ca.nome = 'Vereador' and ci.nome = 'TUBARÃO' order by v.voto desc;

-- 19
select ci.nome, max(v.voto) from voto v 
inner join candidato c on c.id = v.candidato 
inner join cidade ci on ci.id = c.cidade 
inner join cargo ca on ca.id = c.cargo and ca.nome = 'Prefeito' group by ci.nome;

-- 20
select p.sigla, ci.nome, sum(v.voto) as quantidade_votos from voto v  
inner join candidato c on c.id = v.candidato
inner join partido p on p.id = c.partido 
inner join cidade ci on ci.id = c.cidade group by p.sigla, ci.nome order by quantidade_votos desc; 

--21
select sum(v.voto + vi.brancos + vi.nulos) from voto v 
inner join candidato c on c.id = v.candidato 
inner join cargo ca on ca.id = c.cargo 
inner join voto_invalido vi on vi.cargo = ca.id where ca.nome = 'Prefeito';