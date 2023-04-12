import java.io.*;
public class Veiculos{
	public static void main(String[] args){
		Passeio[] pass=new Passeio[100];
		Carga[] carg = new Carga[100];
		Leitura in = new Leitura();
		String placa = "";
		int cont =0,cont1=0, cont2=0, exc=0,cont3=0, opcao, i;

		do {
			System.out.print("\n\n\n\n\n===Rodovia Dois Triangulos====\n\n");
			System.out.print("\n1 - Cadastrar Passeio;");
			System.out.print("\n2 - Cadastrar Carga");
			System.out.print("\n3 - Mostrar todos os veiculos de Passeio");
			System.out.print("\n4 - Mostrar veiculo de Passeio pela placa;");
			System.out.print("\n5 - Apagar um veiculo de Passeio pela Placa");
			System.out.print("\n6 - Mostrar todos os veiculos de Carga");
			System.out.print("\n7 - Mostrar veiculo de Carga pela placa");
			System.out.print("\n8 - Apagar um veiculo de Carga pela Placa;");
			System.out.print("\n9 - Sair do sistema");
			System.out.print("\n\n");
			opcao = Integer.parseInt( in.entra("\nDigite sua opcao:..."));


			switch (opcao){
				case 1:
                    if(pass[cont1] == null){
                        pass[cont1] = new Passeio();
                        System.out.println("\n======Cadastro de Carros de Passeio======\n");
                        pass[cont1].setPlaca(in.entra("Dig.  Placa do Veiculo:..."));
                        pass[cont1].setMarca(in.entra("Dig. marca do veiculo:..."));
                        pass[cont1].setModelo(in.entra("Dig. o modelo do veiculo:..."));
                        pass[cont1].setCor(in.entra("Dig. a cor do veiculo:..."));
                        pass[cont1].setRodas(Integer.parseInt(in.entra("Dig. a quantidade de rodas:...")));
                        pass[cont1].getMotor().setPistoes(Integer.parseInt(in.entra("Dig. a quantidade de pistoes:...")));
                        pass[cont1].getMotor().setPotencia(Integer.parseInt(in.entra("Dig. a potencia do motor:...")));
                        pass[cont1].setPassageiros(Integer.parseInt(in.entra("Dig. a qtd de passageiros:...")));
                        pass[cont1].setVelocMax(Integer.parseInt(in.entra("Dig. a velocidade maxima:...")));
                        cont1++;
                    }
					break;

				case 2:
                    if(carg[cont2]==null){
                        carg[cont2] = new Carga();
                        System.out.println("\n======Cadastro de Carros de Carga======\n");
                        carg[cont2].setPlaca(in.entra("Dig. a Placa do Veiculo:..."));
                        carg[cont2].setMarca(in.entra("Dig. a marca do veiculo:..."));
                        carg[cont2].setModelo(in.entra("Dig. o modelo do veiculo:..."));
                        carg[cont2].setCor(in.entra("Dig. a cor do veiculo:..."));
                        carg[cont2].setRodas(Integer.parseInt(in.entra("Dig. a quantidade de rodas:...")));
                        carg[cont2].getMotor().setPistoes(Integer.parseInt(in.entra("Dig. a quantidade de pistoes:...")));
                        carg[cont2].getMotor().setPotencia(Integer.parseInt(in.entra("Dig. a potencia do motor:...")));
                        carg[cont2].setTara(Integer.parseInt(in.entra("Dig. a Tara:...")));
						carg[cont2].setCargaMax(Integer.parseInt(in.entra("Dig. a Carga Maxima do Veiculo:...")));
                        carg[cont2].setVelocMax(Integer.parseInt(in.entra("Dig. a Velocidade Maxima:...")));
                        cont2++;
                    }
					break;

				case 3:
                cont3 =0;
				for(i=0;i<=con1;i++){
                    if(pass[i] != null){
                        System.out.println("\n======Carros de Passeio======\n");
                        System.out.println("\nPlaca:..."+pass[i].getPlaca());
                        System.out.println("\nMarca:..."+pass[i].getMarca());
                        System.out.println("\nModelo:.."+pass[i].getModelo());
                        System.out.println("\nCor:....."+pass[i].getCor());
                        System.out.println("\nQuantidade de Rodas:..."+pass[i].getRodas());
                        System.out.println("\nQuantidade de Pistoes:..."+pass[i].getMotor().getPistoes());
                        System.out.println("\nPotencia do Carro:..."+pass[i].getMotor().getPotencia());
                        System.out.println("\nQuantidade de Passageiros:..."+pass[i].getPassageiros());
                        System.out.println("\nVelocidade Maxima:..."+pass[i].calcVel()+"M/h");
                        cont3=1;
                    }
				}
				if (cont3 == 0){
                    System.out.println("Nenhum Veiculo Cadastrado");
				}
					break;

				case 4:
					System.out.println("\n======Busca de Veiculo de Passeio=======\n");
                    if(pass[0]!=null){
                        System.out.println("Digite a Placa do Veiculo:...");
                        placa = in.entra("Digite a Placa do Veiculo");
                        for(i=0; i<con1; i++){
                            if(pass[i].getPlaca().equals(placa) ){
                                System.out.println("\n\n======Carros de Passeio======\n\n");
                                System.out.println("\nPlaca:..."+pass[i].getPlaca());
                                System.out.println("\nMarca:..."+pass[i].getMarca());
                                System.out.println("\nModelo:.."+pass[i].getModelo());
                                System.out.println("\nCor:....."+pass[i].getCor());
                                System.out.println("\nQuantidade de Rodas:..."+pass[i].getRodas());
                                System.out.println("\nQuantidade de Pistoes:..."+pass[i].getMotor().getPistoes());
                                System.out.println("\nPotencia do Carro:..."+pass[i].getMotor().getPotencia());
                                System.out.println("\nQuantidade de Passageiros:..."+pass[i].getPassageiros());
                                System.out.println("\nVelocidade Maxima:..."+pass[i].calcVel()+"M/h");
                                cont3=1;

                            }
                        }
                        if(cont3!=1){
                            System.out.println("Placa nao encontrada");
                        }

                    }else {
						System.out.println("Nenhum Veiculo Cadastrado");
					}

					break;

				case 5:
					System.out.println("\n======Excluir Veiculo de Passeio======\n");

                    if(pass[0] != null){
                        System.out.println("Digite a Placa do Veiculo:...");
                        placa = in.entra("Digite a Placa do Veiculo");
                        cont3=0;
                        for(i=0; i<=con1; i++){
                            if(pass[i].getPlaca().equals(placa) ){
                                for(exc=i; exc<con1; exc++){
                                    pass[i]=pass[i+1];
                                }
                             con1 = con1-1;
                             cont3=1;
                            }
                        }
                        if(cont3==0){
                            System.out.println("Placa nao encontrada");
                        }

                    }

					else {
						System.out.println("Nenhum Veiculo Cadastrado");
					}
					break;

				case 6:
				cont3=0;
				    for(i=0;i<=cont2;i++){
                        if(carg[i] != null){
                            System.out.println("\n======Carros de Carga======\n");
                            System.out.println("\nPlaca:..."+carg[i].getPlaca());
                            System.out.println("\nMarca:..."+carg[i].getMarca());
                            System.out.println("\nModelo:.."+carg[i].getModelo());
                            System.out.println("\nCor:....."+carg[i].getCor());
                            System.out.println("\nQuantidade de Rodas:..."+carg[i].getRodas());
                            System.out.println("\nQuantidade de Pistoes:..."+carg[i].getMotor().getPistoes());
                            System.out.println("\nPotencia do Carro:..."+carg[i].getMotor().getPotencia());
                            System.out.println("\nCarga Maxima:..."+carg[i].getCargaMax());
                            System.out.println("\nTara:..."+carg[i].getTara());
                            System.out.println("\nVelocidade Maxima:..."+carg[i].calcVel()+"Cm/h");
                        cont3=1;
						}
                    }
					if (cont3 == 0){
						System.out.println("Nenhum Veiculo Cadastrado");
					}
				    break;

                case 7:
                    System.out.println("\n======Busca de Veiculo de Carga=======\n");
					
					if(carg[0]!=null){	
						System.out.println("Digite a Placa do Veiculo:...");
						placa = in.entra("Digite a Placa do Veiculo");
						for(i=0; i<cont2; i++){
							if(carg[i].getPlaca().equals(placa)){
								System.out.println("\n======Carros de Carga======\n");
								System.out.println("\nPlaca:..."+carg[i].getPlaca());
								System.out.println("\nMarca:..."+carg[i].getMarca());
								System.out.println("\nModelo:.."+carg[i].getModelo());
								System.out.println("\nCor:....."+carg[i].getCor());
								System.out.println("\nQuantidade de Rodas:..."+carg[i].getRodas());
								System.out.println("\nQuantidade de Pistoes:..."+carg[i].getMotor().getPistoes());
								System.out.println("\nPotencia do Carro:..."+carg[i].getMotor().getPotencia());
								System.out.println("\nCarga Maxima:..."+carg[i].getCargaMax());
								System.out.println("\nTara:..."+carg[i].getTara());
								System.out.println("\nVelocidade Maxima:..."+carg[i].calcVel()+"Cm/h");
							cont3=1;
							}
						}if(cont3!=1){
                            System.out.println("Placa nao encontrada");
                        }
					}else {
						System.out.println("Nenhum Veiculo Cadastrado");
					}
                    break;

                case 8:
                    System.out.println("\n======Excluir Veiculo de Carga======\n");
                    if(carg[0] != null){
                        System.out.println("Digite a Placa do Veiculo:...");
                        placa = in.entra("Digite a Placa do Veiculo");
                        cont3=0;
                        for(i=0; i<=cont2; i++){
                            if(carg[i].getPlaca().equals(placa) ){
                                for(exc=i; exc<cont2; exc++){
                                    carg[i]=carg[i+1];
                                }
                             cont2= cont2-1;
                             cont3=1;
                            }
                        }
                        if(cont3==0){
                            System.out.println("Placa nao encontrada");
                        }

                    }

					else {
						System.out.println("Nenhum Veiculo Cadastrado");
					}
                    break;


				}


		}while(opcao!=9);


		}
}
