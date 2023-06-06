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
inner join cidade ci on ci.id = c.cidade and ci.nome = 'TUBARÃO'
inner join cargo ca on ca.id = c.cargo  and ca.nome = 'Prefeito' order by c.nome;

-- 12
select c.nome from candidato c 
inner join cidade ci on ci.id = c.cidade and ci.qt_eleitores = (select max(qt_eleitores) from cidade)
inner join cargo ca on ca.id = c.cargo  and ca.nome = 'Prefeito';

-- 13
select count(*) from candidato c 
inner join cidade ci on ci.id = c.cidade and ci.nome = 'TUBARÃO' 
inner join cargo ca on ca.id = c.cargo and ca.nome = 'Vereador';

-- 14
select ci.nome, count(*)from candidato c 
inner join cidade ci on ci.id = c.cidade 
inner join cargo ca on ca.id = c.cargo and ca.nome = 'Vereador' group by ci.nome order by ci.nome;

-- 15
select ca.nome, vi.brancos, vi.nulos from cargo ca 
inner join voto_invalido vi on vi.cargo = ca.id 
inner join cidade ci on ci.id = vi.cidade and ci.nome = 'TUBARÃO';

-- 16
select vi.nulos + vi.brancos from voto_invalido vi 
inner join cidade ci ON ci.id = vi.cidade and ci.nome = 'TUBARÃO' 
inner join cargo ca on ca.id = vi.cargo and ca.nome = 'Prefeito'; 

-- 17
select v.voto, c.nome from voto v 
inner join candidato c on c.id = v.candidato 
inner join cidade ci on ci.id = c.cidade and ci.nome = 'TUBARÃO' 
inner join cargo ca on ca.id = c.cargo and ca.nome = 'Prefeito' order by v.voto desc;

-- 18
select  v.voto, c.nome from voto v 
inner join candidato c on c.id = v.candidato 
inner join cidade ci on ci.id = c.cidade and ci.nome = 'TUBARÃO'
inner join cargo ca on ca.id = c.cargo and ca.nome = 'Vereador'  order by v.voto desc;

-- 19
select  max(v.voto), ci.nome as NOME_CIDADE from voto v 
inner join candidato c on c.id = v.candidato 
inner join cidade ci on ci.id = c.cidade 
inner join cargo ca on ca.id = c.cargo and ca.nome = 'Prefeito' group by ci.nome;

-- 20
select p.sigla, sum(v.voto) as quantidade_votos from partido p
inner join candidato c on c.partido = p.id 
inner join voto v on v.candidato = c.id 
inner join cidade ci on ci.id = c.cidade and ci.nome = 'TUBARÃO' 
group by p.sigla
order by quantidade_votos desc; 

--21
select v.voto + vi.brancos + vi.nulos from voto v 
inner join candidato c on c.id = v.candidato 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
inner join cidade ci on ci.id = c.cidade and ci.nome = 'TUBARÃO'
inner join voto_invalido vi on vi.cidade = ci.id and vi.cargo = cargo.id; 



--22
select ci.qt_eleitores - (vi.brancos + vi.nulos + v.voto)  from cidade ci
inner join candidato c on c.cidade = ci.id 
inner join voto v on v.candidato = c.id 
inner join voto_invalido vi on vi.cidade = ci.id 
where ci.nome = 'TUBARÃO';

--23
select