package def;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Competicion laLiga= new Competicion("La Liga EA Sports");
		
		Equipo Barca = new Equipo("FC Negreira");
		Equipo Madrid=new Equipo("Real Robos de Madrid");
		Equipo Villareal = new Equipo("Villareal");
		Equipo Atleti=new Equipo("Patetico de Madrid");
		Equipo Betis = new Equipo("Real Betis CF");
		Equipo Bilbao=new Equipo("Athletic Club de Bilbao");
		Equipo RealSociedad = new Equipo("Real Sociedad");
		Equipo Espanyol = new Equipo("RCD Espanyol");
		Equipo Elche = new Equipo("Elche CF");
		Equipo Sevilla = new Equipo("Sevilla FC");
		Equipo Alaves = new Equipo("Deportivo Alavés");
		Equipo RayoVallecano = new Equipo("Rayo Vallecano");
		Equipo Getafe = new Equipo("Getafe CF");
		Equipo Osasuna = new Equipo("CA Osasuna");
		Equipo Valencia = new Equipo("Valencia CF");
		Equipo Levante = new Equipo("Levante UD");
		Equipo Mallorca = new Equipo("RCD Mallorca");
		Equipo CeltaVigo = new Equipo("RC Celta de Vigo");
		Equipo RealOviedo = new Equipo("Real Oviedo");
		Equipo Girona = new Equipo("Girona FC");

		
		
		HashSet<Equipo> listaEquipos=new HashSet<>( List.of(
		        Barca,
		        Madrid,
		        Villareal,
		        Atleti,
		        Betis,
		        Bilbao,
		        RealSociedad,
		        Espanyol,
		        Elche,
		        Sevilla,
		        Alaves,
		        RayoVallecano,
		        Getafe,
		        Osasuna,
		        Valencia,
		        Levante,
		        Mallorca,
		        CeltaVigo,
		        RealOviedo,
		        Girona
		    ));
		
		laLiga.anyadeEquipo(Barca);
		laLiga.anyadeEquipo(Madrid);
		laLiga.anyadeEquipos(listaEquipos);
		
		Jugador jugador1=new Jugador("Messi",10,Barca);
		
		Entrenador entrenador1 =new Entrenador("Hansi Flick",Barca);
		
		Arbitro arbitro1=new Arbitro("Alexandru");
		Arbitro arbitro2=new Arbitro("Andrea");
	
		// JORNADAS 1-10
		Partido p1 = new Partido(Barca, Madrid); p1.resultado(10,0);
		Partido p2 = new Partido(Villareal, Atleti); p2.resultado(1,2);
		Partido p3 = new Partido(Betis, Bilbao); p3.resultado(2,2);
		Partido p4 = new Partido(RealSociedad, Espanyol); p4.resultado(2,0);
		Partido p5 = new Partido(Elche, Sevilla); p5.resultado(1,3);
		Partido p6 = new Partido(Alaves, RayoVallecano); p6.resultado(0,1);
		Partido p7 = new Partido(Getafe, Osasuna); p7.resultado(1,0);
		Partido p8 = new Partido(Valencia, Levante); p8.resultado(2,1);
		Partido p9 = new Partido(Mallorca, CeltaVigo); p9.resultado(1,1);
		Partido p10 = new Partido(RealOviedo, Girona); p10.resultado(0,2);

		Partido p11 = new Partido(Madrid, Villareal); p11.resultado(4,1);
		Partido p12 = new Partido(Atleti, Barca); p12.resultado(4,1);
		Partido p13 = new Partido(Bilbao, RealSociedad); p13.resultado(3,1);
		Partido p14 = new Partido(Espanyol, Betis); p14.resultado(0,2);
		Partido p15 = new Partido(Sevilla, Alaves); p15.resultado(2,0);
		Partido p16 = new Partido(RayoVallecano, Elche); p16.resultado(2,1);
		Partido p17 = new Partido(Osasuna, Valencia); p17.resultado(1,2);
		Partido p18 = new Partido(Levante, Getafe); p18.resultado(0,0);
		Partido p19 = new Partido(CeltaVigo, RealOviedo); p19.resultado(2,0);
		Partido p20 = new Partido(Girona, Mallorca); p20.resultado(1,3);

		Partido p21 = new Partido(Barca, Villareal); p21.resultado(2,0);
		Partido p22 = new Partido(Madrid, Atleti); p22.resultado(2,2);
		Partido p23 = new Partido(Betis, RealSociedad); p23.resultado(1,0);
		Partido p24 = new Partido(Bilbao, Espanyol); p24.resultado(3,0);
		Partido p25 = new Partido(Sevilla, RayoVallecano); p25.resultado(2,2);
		Partido p26 = new Partido(Elche, Alaves); p26.resultado(1,1);
		Partido p27 = new Partido(Valencia, Getafe); p27.resultado(2,0);
		Partido p28 = new Partido(Osasuna, Levante); p28.resultado(1,0);
		Partido p29 = new Partido(Mallorca, RealOviedo); p29.resultado(2,1);
		Partido p30 = new Partido(CeltaVigo, Girona); p30.resultado(1,3);

		Partido p31 = new Partido(Barca, Atleti); p31.resultado(4,1);
		Partido p32 = new Partido(Madrid, Betis); p32.resultado(3,0);
		Partido p33 = new Partido(Villareal, Bilbao); p33.resultado(1,1);
		Partido p34 = new Partido(RealSociedad, Sevilla); p34.resultado(2,2);
		Partido p35 = new Partido(Espanyol, Alaves); p35.resultado(1,0);
		Partido p36 = new Partido(RayoVallecano, Valencia); p36.resultado(0,2);
		Partido p37 = new Partido(Getafe, Mallorca); p37.resultado(1,1);
		Partido p38 = new Partido(Osasuna, CeltaVigo); p38.resultado(2,1);
		Partido p39 = new Partido(Levante, Girona); p39.resultado(0,1);
		Partido p40 = new Partido(RealOviedo, Elche); p40.resultado(1,0);

		Partido p41 = new Partido(Barca, Betis); p41.resultado(4,1);
		Partido p42 = new Partido(Madrid, Bilbao); p42.resultado(2,1);
		Partido p43 = new Partido(Villareal, RealSociedad); p43.resultado(0,2);
		Partido p44 = new Partido(Atleti, Sevilla); p44.resultado(3,1);
		Partido p45 = new Partido(Espanyol, RayoVallecano); p45.resultado(2,2);
		Partido p46 = new Partido(Alaves, Valencia); p46.resultado(1,3);
		Partido p47 = new Partido(Getafe, CeltaVigo); p47.resultado(0,1);
		Partido p48 = new Partido(Osasuna, Mallorca); p48.resultado(1,0);
		Partido p49 = new Partido(Levante, RealOviedo); p49.resultado(2,0);
		Partido p50 = new Partido(Girona, Elche); p50.resultado(3,1);

		Partido p51 = new Partido(Barca, Bilbao); p51.resultado(6,2);
		Partido p52 = new Partido(Madrid, RealSociedad); p52.resultado(3,1);
		Partido p53 = new Partido(Villareal, Betis); p53.resultado(1,2);
		Partido p54 = new Partido(Atleti, Espanyol); p54.resultado(2,0);
		Partido p55 = new Partido(Sevilla, Valencia); p55.resultado(1,2);
		Partido p56 = new Partido(Alaves, Getafe); p56.resultado(0,0);
		Partido p57 = new Partido(RayoVallecano, Osasuna); p57.resultado(1,1);
		Partido p58 = new Partido(Mallorca, Levante); p58.resultado(2,1);
		Partido p59 = new Partido(CeltaVigo, Girona); p59.resultado(2,3);
		Partido p60 = new Partido(RealOviedo, Elche); p60.resultado(1,2);

		Partido p61 = new Partido(Barca, RealSociedad); p61.resultado(3,0);
		Partido p62 = new Partido(Madrid, Sevilla); p62.resultado(2,2);
		Partido p63 = new Partido(Villareal, Espanyol); p63.resultado(1,1);
		Partido p64 = new Partido(Atleti, Alaves); p64.resultado(3,0);
		Partido p65 = new Partido(Betis, RayoVallecano); p65.resultado(2,1);
		Partido p66 = new Partido(Bilbao, Valencia); p66.resultado(1,1);
		Partido p67 = new Partido(Getafe, Mallorca); p67.resultado(0,2);
		Partido p68 = new Partido(Osasuna, CeltaVigo); p68.resultado(2,2);
		Partido p69 = new Partido(Levante, Elche); p69.resultado(1,0);
		Partido p70 = new Partido(Girona, RealOviedo); p70.resultado(3,1);

		Partido p71 = new Partido(Barca, Espanyol); p71.resultado(4,0);
		Partido p72 = new Partido(Madrid, Atleti); p72.resultado(2,3);
		Partido p73 = new Partido(Villareal, Bilbao); p73.resultado(1,1);
		Partido p74 = new Partido(RealSociedad, Betis); p74.resultado(2,2);
		Partido p75 = new Partido(Sevilla, RayoVallecano); p75.resultado(3,0);
		Partido p76 = new Partido(Alaves, Osasuna); p76.resultado(1,1);
		Partido p77 = new Partido(Getafe, Levante); p77.resultado(2,0);
		Partido p78 = new Partido(Valencia, CeltaVigo); p78.resultado(1,2);
		Partido p79 = new Partido(Mallorca, Girona); p79.resultado(0,3);
		Partido p80 = new Partido(RealOviedo, Elche); p80.resultado(1,1);

		Partido p81 = new Partido(Barca, Sevilla); p81.resultado(5,2);
		Partido p82 = new Partido(Madrid, Bilbao); p82.resultado(3,1);
		Partido p83 = new Partido(Villareal, RealOviedo); p83.resultado(2,0);
		Partido p84 = new Partido(Atleti, Valencia); p84.resultado(1,1);
		Partido p85 = new Partido(Betis, CeltaVigo); p85.resultado(2,0);
		Partido p86 = new Partido(RealSociedad, Getafe); p86.resultado(3,1);
		Partido p87 = new Partido(Espanyol, Levante); p87.resultado(1,2);
		Partido p88 = new Partido(RayoVallecano, Girona); p88.resultado(0,1);
		Partido p89 = new Partido(Alaves, Mallorca); p89.resultado(1,0);
		Partido p90 = new Partido(Osasuna, Elche); p90.resultado(2,2);

		Partido p91 = new Partido(Barca, Mallorca); p91.resultado(3,1);
		Partido p92 = new Partido(Madrid, Elche); p92.resultado(4,0);
		Partido p93 = new Partido(Villareal, Levante); p93.resultado(2,2);
		Partido p94 = new Partido(Atleti, Getafe); p94.resultado(1,1);
		Partido p95 = new Partido(Betis, Osasuna); p95.resultado(2,1);
		Partido p96 = new Partido(Bilbao, Girona); p96.resultado(1,2);
		Partido p97 = new Partido(RealSociedad, Valencia); p97.resultado(3,0);
		Partido p98 = new Partido(Espanyol, CeltaVigo); p98.resultado(2,1);
		Partido p99 = new Partido(RayoVallecano, Sevilla); p99.resultado(0,3);
		Partido p100 = new Partido(Alaves, RealOviedo); p100.resultado(1,1);

		// JORNADAS 11-20
		Partido p101 = new Partido(Barca, Getafe); p101.resultado(2,1);
		Partido p102 = new Partido(Madrid, RayoVallecano); p102.resultado(3,2);
		Partido p103 = new Partido(Villareal, Osasuna); p103.resultado(1,1);
		Partido p104 = new Partido(Atleti, Mallorca); p104.resultado(2,0);
		Partido p105 = new Partido(Betis, Levante); p105.resultado(3,1);
		Partido p106 = new Partido(Bilbao, Elche); p106.resultado(1,2);
		Partido p107 = new Partido(RealSociedad, Girona); p107.resultado(2,2);
		Partido p108 = new Partido(Espanyol, CeltaVigo); p108.resultado(1,1);
		Partido p109 = new Partido(Sevilla, Valencia); p109.resultado(2,0);
		Partido p110 = new Partido(Alaves, Barca); p110.resultado(0,3);

		Partido p111 = new Partido(Barca, Levante); p111.resultado(3,0);
		Partido p112 = new Partido(Madrid, Getafe); p112.resultado(2,2);
		Partido p113 = new Partido(Villareal, Girona); p113.resultado(1,3);
		Partido p114 = new Partido(Atleti, Osasuna); p114.resultado(2,1);
		Partido p115 = new Partido(Betis, Mallorca); p115.resultado(2,0);
		Partido p116 = new Partido(Bilbao, RayoVallecano); p116.resultado(1,1);
		Partido p117 = new Partido(RealSociedad, Elche); p117.resultado(3,1);
		Partido p118 = new Partido(Espanyol, Valencia); p118.resultado(1,2);
		Partido p119 = new Partido(Sevilla, CeltaVigo); p119.resultado(2,2);
		Partido p120 = new Partido(Alaves, Villareal); p120.resultado(1,1);

		Partido p121 = new Partido(Barca, Girona); p121.resultado(4,1);
		Partido p122 = new Partido(Madrid, Levante); p122.resultado(3,0);
		Partido p123 = new Partido(Villareal, Getafe); p123.resultado(2,1);
		Partido p124 = new Partido(Atleti, Elche); p124.resultado(2,2);
		Partido p125 = new Partido(Betis, Osasuna); p125.resultado(1,0);
		Partido p126 = new Partido(Bilbao, Mallorca); p126.resultado(2,2);
		Partido p127 = new Partido(RealSociedad, Valencia); p127.resultado(3,1);
		Partido p128 = new Partido(Espanyol, CeltaVigo); p128.resultado(1,3);
		Partido p129 = new Partido(Sevilla, RayoVallecano); p129.resultado(2,1);
		Partido p130 = new Partido(Alaves, Barca); p130.resultado(0,2);

		Partido p131 = new Partido(Barca, Elche); p131.resultado(2,0);
		Partido p132 = new Partido(Madrid, Osasuna); p132.resultado(3,1);
		Partido p133 = new Partido(Villareal, Valencia); p133.resultado(1,2);
		Partido p134 = new Partido(Atleti, Girona); p134.resultado(1,3);
		Partido p135 = new Partido(Betis, CeltaVigo); p135.resultado(2,1);
		Partido p136 = new Partido(Bilbao, Levante); p136.resultado(1,0);
		Partido p137 = new Partido(RealSociedad, RayoVallecano); p137.resultado(2,2);
		Partido p138 = new Partido(Espanyol, Mallorca); p138.resultado(0,1);
		Partido p139 = new Partido(Sevilla, Getafe); p139.resultado(3,2);
		Partido p140 = new Partido(Alaves, Villareal); p140.resultado(1,1);

		Partido p141 = new Partido(Barca, CeltaVigo); p141.resultado(3,1);
		Partido p142 = new Partido(Madrid, Girona); p142.resultado(2,0);
		Partido p143 = new Partido(Villareal, Levante); p143.resultado(1,1);
		Partido p144 = new Partido(Atleti, Getafe); p144.resultado(2,2);
		Partido p145 = new Partido(Betis, RayoVallecano); p145.resultado(2,0);
		Partido p146 = new Partido(Bilbao, Elche); p146.resultado(1,1);
		Partido p147 = new Partido(RealSociedad, Mallorca); p147.resultado(3,0);
		Partido p148 = new Partido(Espanyol, Valencia); p148.resultado(1,2);
		Partido p149 = new Partido(Sevilla, Osasuna); p149.resultado(2,1);
		Partido p150 = new Partido(Alaves, Barca); p150.resultado(0,3);

		Partido p151 = new Partido(Barca, RayoVallecano); p151.resultado(2,1);
		Partido p152 = new Partido(Madrid, Elche); p152.resultado(3,0);
		Partido p153 = new Partido(Villareal, Osasuna); p153.resultado(1,1);
		Partido p154 = new Partido(Atleti, Valencia); p154.resultado(2,1);
		Partido p155 = new Partido(Betis, Getafe); p155.resultado(3,1);
		Partido p156 = new Partido(Bilbao, CeltaVigo); p156.resultado(1,2);
		Partido p157 = new Partido(RealSociedad, Girona); p157.resultado(2,2);
		Partido p158 = new Partido(Espanyol, Levante); p158.resultado(1,0);
		Partido p159 = new Partido(Sevilla, Mallorca); p159.resultado(3,1);
		Partido p160 = new Partido(Alaves, Villareal); p160.resultado(1,1);

		Partido p161 = new Partido(Barca, Osasuna); p161.resultado(2,0);
		Partido p162 = new Partido(Madrid, Girona); p162.resultado(4,1);
		Partido p163 = new Partido(Villareal, CeltaVigo); p163.resultado(1,2);
		Partido p164 = new Partido(Atleti, Levante); p164.resultado(3,0);
		Partido p165 = new Partido(Betis, Mallorca); p165.resultado(2,1);
		Partido p166 = new Partido(Bilbao, RayoVallecano); p166.resultado(1,2);
		Partido p167 = new Partido(RealSociedad, Elche); p167.resultado(3,0);
		Partido p168 = new Partido(Espanyol, Valencia); p168.resultado(2,1);
		Partido p169 = new Partido(Sevilla, Getafe); p169.resultado(1,1);
		Partido p170 = new Partido(Alaves, Barca); p170.resultado(0,3);

		Partido p171 = new Partido(Barca, Valencia); p171.resultado(3,2);
		Partido p172 = new Partido(Madrid, Mallorca); p172.resultado(2,0);
		Partido p173 = new Partido(Villareal, RayoVallecano); p173.resultado(1,1);
		Partido p174 = new Partido(Atleti, Elche); p174.resultado(2,2);
		Partido p175 = new Partido(Betis, Girona); p175.resultado(3,1);
		Partido p176 = new Partido(Bilbao, Levante); p176.resultado(1,0);
		Partido p177 = new Partido(RealSociedad, Getafe); p177.resultado(2,1);
		Partido p178 = new Partido(Espanyol, CeltaVigo); p178.resultado(1,3);
		Partido p179 = new Partido(Sevilla, Osasuna); p179.resultado(2,2);
		Partido p180 = new Partido(Alaves, Villareal); p180.resultado(1,1);

		Partido p181 = new Partido(Barca, Mallorca); p181.resultado(3,1);
		Partido p182 = new Partido(Madrid, Elche); p182.resultado(4,0);
		Partido p183 = new Partido(Villareal, Levante); p183.resultado(2,2);
		Partido p184 = new Partido(Atleti, Getafe); p184.resultado(1,1);
		Partido p185 = new Partido(Betis, Osasuna); p185.resultado(2,1);
		Partido p186 = new Partido(Bilbao, Girona); p186.resultado(1,2);
		Partido p187 = new Partido(RealSociedad, Valencia); p187.resultado(3,0);
		Partido p188 = new Partido(Espanyol, CeltaVigo); p188.resultado(2,1);
		Partido p189 = new Partido(RayoVallecano, Sevilla); p189.resultado(0,3);
		Partido p190 = new Partido(Alaves, RealOviedo); p190.resultado(1,1);

		Partido p191 = new Partido(Barca, Getafe); p191.resultado(2,1);
		Partido p192 = new Partido(Madrid, RayoVallecano); p192.resultado(3,2);
		Partido p193 = new Partido(Villareal, Osasuna); p193.resultado(1,1);
		Partido p194 = new Partido(Atleti, Mallorca); p194.resultado(2,0);
		Partido p195 = new Partido(Betis, Levante); p195.resultado(3,1);
		Partido p196 = new Partido(Bilbao, Elche); p196.resultado(1,2);
		Partido p197 = new Partido(RealSociedad, Girona); p197.resultado(2,2);
		Partido p198 = new Partido(Espanyol, CeltaVigo); p198.resultado(1,1);
		Partido p199 = new Partido(Sevilla, Valencia); p199.resultado(2,0);
		Partido p200 = new Partido(Alaves, Barca); p200.resultado(0,3);

		// JORNADAS 21-30
		Partido p201 = new Partido(Barca, Levante); p201.resultado(3,0);
		Partido p202 = new Partido(Madrid, Getafe); p202.resultado(2,1);
		Partido p203 = new Partido(Villareal, Girona); p203.resultado(1,2);
		Partido p204 = new Partido(Atleti, Osasuna); p204.resultado(2,1);
		Partido p205 = new Partido(Betis, Mallorca); p205.resultado(2,0);
		Partido p206 = new Partido(Bilbao, RayoVallecano); p206.resultado(1,1);
		Partido p207 = new Partido(RealSociedad, Elche); p207.resultado(3,1);
		Partido p208 = new Partido(Espanyol, Valencia); p208.resultado(1,2);
		Partido p209 = new Partido(Sevilla, CeltaVigo); p209.resultado(2,2);
		Partido p210 = new Partido(Alaves, Villareal); p210.resultado(1,1);

		Partido p211 = new Partido(Barca, Girona); p211.resultado(4,1);
		Partido p212 = new Partido(Madrid, Levante); p212.resultado(3,0);
		Partido p213 = new Partido(Villareal, Getafe); p213.resultado(2,1);
		Partido p214 = new Partido(Atleti, Elche); p214.resultado(2,2);
		Partido p215 = new Partido(Betis, Osasuna); p215.resultado(1,0);
		Partido p216 = new Partido(Bilbao, Mallorca); p216.resultado(2,2);
		Partido p217 = new Partido(RealSociedad, Valencia); p217.resultado(3,1);
		Partido p218 = new Partido(Espanyol, CeltaVigo); p218.resultado(1,3);
		Partido p219 = new Partido(Sevilla, RayoVallecano); p219.resultado(2,1);
		Partido p220 = new Partido(Alaves, Barca); p220.resultado(0,2);

		Partido p221 = new Partido(Barca, Elche); p221.resultado(2,0);
		Partido p222 = new Partido(Madrid, Osasuna); p222.resultado(3,1);
		Partido p223 = new Partido(Villareal, Valencia); p223.resultado(1,2);
		Partido p224 = new Partido(Atleti, Girona); p224.resultado(1,3);
		Partido p225 = new Partido(Betis, CeltaVigo); p225.resultado(2,1);
		Partido p226 = new Partido(Bilbao, Levante); p226.resultado(1,0);
		Partido p227 = new Partido(RealSociedad, RayoVallecano); p227.resultado(2,2);
		Partido p228 = new Partido(Espanyol, Mallorca); p228.resultado(0,1);
		Partido p229 = new Partido(Sevilla, Getafe); p229.resultado(3,2);
		Partido p230 = new Partido(Alaves, Villareal); p230.resultado(1,1);

		Partido p231 = new Partido(Barca, CeltaVigo); p231.resultado(3,1);
		Partido p232 = new Partido(Madrid, Girona); p232.resultado(2,0);
		Partido p233 = new Partido(Villareal, Levante); p233.resultado(1,1);
		Partido p234 = new Partido(Atleti, Getafe); p234.resultado(2,2);
		Partido p235 = new Partido(Betis, RayoVallecano); p235.resultado(2,0);
		Partido p236 = new Partido(Bilbao, Elche); p236.resultado(1,1);
		Partido p237 = new Partido(RealSociedad, Mallorca); p237.resultado(3,0);
		Partido p238 = new Partido(Espanyol, Valencia); p238.resultado(1,2);
		Partido p239 = new Partido(Sevilla, Osasuna); p239.resultado(2,1);
		Partido p240 = new Partido(Alaves, Barca); p240.resultado(0,3);

		Partido p241 = new Partido(Barca, RayoVallecano); p241.resultado(2,1);
		Partido p242 = new Partido(Madrid, Elche); p242.resultado(3,0);
		Partido p243 = new Partido(Villareal, Osasuna); p243.resultado(1,1);
		Partido p244 = new Partido(Atleti, Valencia); p244.resultado(2,1);
		Partido p245 = new Partido(Betis, Getafe); p245.resultado(3,1);
		Partido p246 = new Partido(Bilbao, CeltaVigo); p246.resultado(1,2);
		Partido p247 = new Partido(RealSociedad, Girona); p247.resultado(2,2);
		Partido p248 = new Partido(Espanyol, Levante); p248.resultado(1,0);
		Partido p249 = new Partido(Sevilla, Mallorca); p249.resultado(3,1);
		Partido p250 = new Partido(Alaves, Villareal); p250.resultado(1,1);

		Partido p251 = new Partido(Barca, Osasuna); p251.resultado(2,0);
		Partido p252 = new Partido(Madrid, Girona); p252.resultado(4,1);
		Partido p253 = new Partido(Villareal, CeltaVigo); p253.resultado(1,2);
		Partido p254 = new Partido(Atleti, Levante); p254.resultado(3,0);
		Partido p255 = new Partido(Betis, Mallorca); p255.resultado(2,1);
		Partido p256 = new Partido(Bilbao, RayoVallecano); p256.resultado(1,2);
		Partido p257 = new Partido(RealSociedad, Elche); p257.resultado(3,0);
		Partido p258 = new Partido(Espanyol, Valencia); p258.resultado(2,1);
		Partido p259 = new Partido(Sevilla, Getafe); p259.resultado(1,1);
		Partido p260 = new Partido(Alaves, Barca); p260.resultado(0,3);

		Partido p261 = new Partido(Barca, Valencia); p261.resultado(3,2);
		Partido p262 = new Partido(Madrid, Mallorca); p262.resultado(2,0);
		Partido p263 = new Partido(Villareal, RayoVallecano); p263.resultado(1,1);
		Partido p264 = new Partido(Atleti, Elche); p264.resultado(2,2);
		Partido p265 = new Partido(Betis, Girona); p265.resultado(3,1);
		Partido p266 = new Partido(Bilbao, Levante); p266.resultado(1,0);
		Partido p267 = new Partido(RealSociedad, Getafe); p267.resultado(2,1);
		Partido p268 = new Partido(Espanyol, CeltaVigo); p268.resultado(1,3);
		Partido p269 = new Partido(Sevilla, Osasuna); p269.resultado(2,2);
		Partido p270 = new Partido(Alaves, Villareal); p270.resultado(1,1);

		Partido p271 = new Partido(Barca, Mallorca); p271.resultado(3,1);
		Partido p272 = new Partido(Madrid, Elche); p272.resultado(4,0);
		Partido p273 = new Partido(Villareal, Levante); p273.resultado(2,2);
		Partido p274 = new Partido(Atleti, Getafe); p274.resultado(1,1);
		Partido p275 = new Partido(Betis, Osasuna); p275.resultado(2,1);
		Partido p276 = new Partido(Bilbao, Girona); p276.resultado(1,2);
		Partido p277 = new Partido(RealSociedad, Valencia); p277.resultado(3,0);
		Partido p278 = new Partido(Espanyol, CeltaVigo); p278.resultado(2,1);
		Partido p279 = new Partido(RayoVallecano, Sevilla); p279.resultado(0,3);
		Partido p280 = new Partido(Alaves, RealOviedo); p280.resultado(1,1);

		// JORNADAS 31-38
		Partido p281 = new Partido(Barca, Getafe); p281.resultado(2,1);
		Partido p282 = new Partido(Madrid, RayoVallecano); p282.resultado(3,2);
		Partido p283 = new Partido(Villareal, Osasuna); p283.resultado(1,1);
		Partido p284 = new Partido(Atleti, Mallorca); p284.resultado(2,0);
		Partido p285 = new Partido(Betis, Levante); p285.resultado(3,1);
		Partido p286 = new Partido(Bilbao, Elche); p286.resultado(1,2);
		Partido p287 = new Partido(RealSociedad, Girona); p287.resultado(2,2);
		Partido p288 = new Partido(Espanyol, CeltaVigo); p288.resultado(1,1);
		Partido p289 = new Partido(Sevilla, Valencia); p289.resultado(2,0);
		Partido p290 = new Partido(Alaves, Villareal); p290.resultado(1,1);

		Partido p291 = new Partido(Barca, Girona); p291.resultado(4,1);
		Partido p292 = new Partido(Madrid, Levante); p292.resultado(3,0);
		Partido p293 = new Partido(Villareal, Getafe); p293.resultado(2,1);
		Partido p294 = new Partido(Atleti, Elche); p294.resultado(2,2);
		Partido p295 = new Partido(Betis, Osasuna); p295.resultado(1,0);
		Partido p296 = new Partido(Bilbao, Mallorca); p296.resultado(2,2);
		Partido p297 = new Partido(RealSociedad, Valencia); p297.resultado(3,1);
		Partido p298 = new Partido(Espanyol, CeltaVigo); p298.resultado(1,3);
		Partido p299 = new Partido(Sevilla, RayoVallecano); p299.resultado(2,1);
		Partido p300 = new Partido(Alaves, Barca); p300.resultado(0,2);

		Partido p301 = new Partido(Barca, Elche); p301.resultado(2,0);
		Partido p302 = new Partido(Madrid, Osasuna); p302.resultado(3,1);
		Partido p303 = new Partido(Villareal, Valencia); p303.resultado(1,2);
		Partido p304 = new Partido(Atleti, Girona); p304.resultado(1,3);
		Partido p305 = new Partido(Betis, CeltaVigo); p305.resultado(2,1);
		Partido p306 = new Partido(Bilbao, Levante); p306.resultado(1,0);
		Partido p307 = new Partido(RealSociedad, RayoVallecano); p307.resultado(2,2);
		Partido p308 = new Partido(Espanyol, Mallorca); p308.resultado(0,1);
		Partido p309 = new Partido(Sevilla, Getafe); p309.resultado(3,2);
		Partido p310 = new Partido(Alaves, Villareal); p310.resultado(1,1);

		Partido p311 = new Partido(Barca, CeltaVigo); p311.resultado(3,1);
		Partido p312 = new Partido(Madrid, Girona); p312.resultado(2,0);
		Partido p313 = new Partido(Villareal, Levante); p313.resultado(1,1);
		Partido p314 = new Partido(Atleti, Getafe); p314.resultado(2,2);
		Partido p315 = new Partido(Betis, RayoVallecano); p315.resultado(2,0);
		Partido p316 = new Partido(Bilbao, Elche); p316.resultado(1,1);
		Partido p317 = new Partido(RealSociedad, Mallorca); p317.resultado(3,0);
		Partido p318 = new Partido(Espanyol, Valencia); p318.resultado(1,2);
		Partido p319 = new Partido(Sevilla, Osasuna); p319.resultado(2,1);
		Partido p320 = new Partido(Alaves, Barca); p320.resultado(0,3);

		Partido p321 = new Partido(Barca, RayoVallecano); p321.resultado(2,1);
		Partido p322 = new Partido(Madrid, Elche); p322.resultado(3,0);
		Partido p323 = new Partido(Villareal, Osasuna); p323.resultado(1,1);
		Partido p324 = new Partido(Atleti, Valencia); p324.resultado(2,1);
		Partido p325 = new Partido(Betis, Getafe); p325.resultado(3,1);
		Partido p326 = new Partido(Bilbao, CeltaVigo); p326.resultado(1,2);
		Partido p327 = new Partido(RealSociedad, Girona); p327.resultado(2,2);
		Partido p328 = new Partido(Espanyol, Levante); p328.resultado(1,0);
		Partido p329 = new Partido(Sevilla, Mallorca); p329.resultado(3,1);
		Partido p330 = new Partido(Alaves, Villareal); p330.resultado(1,1);

		Partido p331 = new Partido(Barca, Osasuna); p331.resultado(2,0);
		Partido p332 = new Partido(Madrid, Girona); p332.resultado(4,1);
		Partido p333 = new Partido(Villareal, CeltaVigo); p333.resultado(1,2);
		Partido p334 = new Partido(Atleti, Levante); p334.resultado(3,0);
		Partido p335 = new Partido(Betis, Mallorca); p335.resultado(2,1);
		Partido p336 = new Partido(Bilbao, RayoVallecano); p336.resultado(1,2);
		Partido p337 = new Partido(RealSociedad, Elche); p337.resultado(3,0);
		Partido p338 = new Partido(Espanyol, Valencia); p338.resultado(2,1);
		Partido p339 = new Partido(Sevilla, Getafe); p339.resultado(1,1);
		Partido p340 = new Partido(Alaves, Barca); p340.resultado(0,3);

		Partido p341 = new Partido(Barca, Valencia); p341.resultado(3,2);
		Partido p342 = new Partido(Madrid, Mallorca); p342.resultado(2,0);
		Partido p343 = new Partido(Villareal, RayoVallecano); p343.resultado(1,1);
		Partido p344 = new Partido(Atleti, Elche); p344.resultado(2,2);
		Partido p345 = new Partido(Betis, Girona); p345.resultado(3,1);
		Partido p346 = new Partido(Bilbao, Levante); p346.resultado(1,0);
		Partido p347 = new Partido(RealSociedad, Getafe); p347.resultado(2,1);
		Partido p348 = new Partido(Espanyol, CeltaVigo); p348.resultado(1,3);
		Partido p349 = new Partido(Sevilla, Osasuna); p349.resultado(2,2);
		Partido p350 = new Partido(Alaves, Villareal); p350.resultado(1,1);

		Partido p351 = new Partido(Barca, Mallorca); p351.resultado(3,1);
		Partido p352 = new Partido(Madrid, Elche); p352.resultado(4,0);
		Partido p353 = new Partido(Villareal, Levante); p353.resultado(2,2);
		Partido p354 = new Partido(Atleti, Getafe); p354.resultado(1,1);
		Partido p355 = new Partido(Betis, Osasuna); p355.resultado(2,1);
		Partido p356 = new Partido(Bilbao, Girona); p356.resultado(1,2);
		Partido p357 = new Partido(RealSociedad, Valencia); p357.resultado(3,0);
		Partido p358 = new Partido(Espanyol, CeltaVigo); p358.resultado(2,1);
		Partido p359 = new Partido(RayoVallecano, Sevilla); p359.resultado(0,3);
		Partido p360 = new Partido(Alaves, RealOviedo); p360.resultado(1,1);

		
		laLiga.verClasificacion();
		
		laLiga.quienVaPrimero(Villareal, Bilbao);
	}

}
