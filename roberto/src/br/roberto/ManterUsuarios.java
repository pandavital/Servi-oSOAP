package br.roberto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.model.Usuario;;

public class ManterUsuarios {

	public static class EditarUsuario {

		public Scanner sc = new Scanner(System.in);

		public static List<Usuario> Usuarios = new ArrayList<Usuario>();

		public static List<Usuario> getUsuarios() {
			return Usuarios;
		}

		public void fazerCadastro() {

			System.out.println("Digite seu Nome");
			String nome = sc.nextLine();

			System.out.println("Digite seu Login");
			String login = sc.nextLine();

			System.out.println("Informe sua Senha");
			String senha = sc.nextLine();

			Usuario novoUsuario = new Usuario(nome, login, senha);

			adicionarUsuarios(novoUsuario);

		}

		private void adicionarUsuarios(Usuario novoUsuario) {
			if (Usuarios.isEmpty()) {
				Usuarios.add(novoUsuario);

			} else {
				for (Usuario usuario : Usuarios) {

					if (novoUsuario.equals(usuario)) {
					} else {
						Usuarios.add(novoUsuario);
					}

				}
			}

		}

		public void excluirUsuario(String nome) {
			for (Usuario usuario : Usuarios) {
				if (usuario.getNome().equals(nome)) {
					Usuarios.remove(usuario);
				}
			}
		}

		public void editaUsuario(Usuario usuario) {
			for (Usuario usuario2 : Usuarios) {
				if (usuario2.equals(usuario)) {
					System.out.println("Se você deseja altera sua Senha digite 1, se dejeja altera o Nome digite 2, "
							+ "se deseja alterar seu Login digite 3,caso não queira fazer alterações digite 4.");

					int codigo = sc.nextInt();

					switch (codigo) {
					case 1:
						System.out.println("Digite a sua nova Senha");
						usuario2.setSenha(sc.nextLine());

						break;

					case 2:
						System.out.println("Digite seu novo Nome");
						usuario2.setNome(sc.nextLine());

						break;

					case 3:
						System.out.println("Digite seu novo Login");
						usuario2.setLogin(sc.nextLine());

						break;

					default:
						throw new IllegalArgumentException("Unexpected value: " + codigo);
					}
				}
			}
		}

		public static Object obterUsuario(Usuario usuario) {
			for (Usuario usuario2 : Usuarios) {
				if (usuario2.equals(usuario)) {
					return usuario;
				}
			}
			return null;
		}
		
		public Usuario fazerLogin(Usuario usuario) {
			for (Usuario usuario2 : Usuarios) {
				if (usuario2.getSenha().equals(usuario.getSenha()) && usuario2.getLogin().equals(usuario.getLogin())) {
					return usuario;
				}	
}	
			System.out.println("Login ou Senha não Encontrado");
			return null;

		}
	}

	

}
