package tema01.Classes;

import tema01.TiposAtaque.PoderDivino;

public class Clerigo {
    public String nome;
    public int vida, ataque, defesa, fe, dano, poderFinal;

    public Clerigo(String nome, int vida, int ataque, int defesa, int fe) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.fe = fe;

    }


    public void ataque(Barbaro barbaro, PoderDivino poder) {
        poderFinal = (poder.ataquePoder * this.ataque);
        dano = poderFinal - barbaro.defesa;

        if (this.vida <= 0) {
            System.out.println(this.nome + " atacou " + barbaro.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está morto)");
        } else if (poder.custoFe > this.fe) {
            System.out.println(this.nome + " atacou " + barbaro.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está sem fé)");
        } else {
            this.fe -= poder.custoFe;
            barbaro.vida -= dano;
            if (barbaro.vida <= 0) {
                barbaro.vida = 0; //para não negativar a vida
                System.out.println(this.nome + " atacou " + barbaro.nome + " com " + poder.nome + " causando " + dano + " de dano e matou o personagem alvo.");
            } else {
                System.out.println(this.nome + " atacou " + barbaro.nome + " com " + poder.nome + " causando " + dano + " de dano.");
            }
        }
    }

    public void ataque(Clerigo clerigo, PoderDivino poder) {
        poderFinal = (poder.ataquePoder * this.ataque);
        dano = poderFinal - clerigo.defesa;

        if (this.vida <= 0) {
            System.out.println(this.nome + " atacou " + clerigo.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está morto)");
        } else if (poder.custoFe > this.fe) {
            System.out.println(this.nome + " atacou " + clerigo.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está sem fé)");
        } else {
            this.fe -= poder.custoFe;
            clerigo.vida -= dano;
            if (clerigo.vida <= 0) {
                clerigo.vida = 0; //para não negativar a vida
                System.out.println(this.nome + " atacou " + clerigo.nome + " com " + poder.nome + " causando " + dano + " de dano e matou o personagem alvo.");
            } else {
                System.out.println(this.nome + " atacou " + clerigo.nome + " com " + poder.nome + " causando " + dano + " de dano.");
            }
        }
    }

    public void ataque(Druida druida, PoderDivino poder) {
        poderFinal = (poder.ataquePoder * this.ataque);
        dano = poderFinal - druida.defesa;

        if (this.vida <= 0) {
            System.out.println(this.nome + " atacou " + druida.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está morto)");
        } else if (poder.custoFe > this.fe) {
            System.out.println(this.nome + " atacou " + druida.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está sem fé)");
        } else {
            this.fe -= poder.custoFe;
            druida.vida -= dano;
            if (druida.vida <= 0) {
                druida.vida = 0; //para não negativar a vida
                System.out.println(this.nome + " atacou " + druida.nome + " com " + poder.nome + " causando " + dano + " de dano e matou o personagem alvo.");
            } else {
                System.out.println(this.nome + " atacou " + druida.nome + " com " + poder.nome + " causando " + dano + " de dano.");
            }
        }
    }

    public void ataque(Feiticeiro feiticeiro, PoderDivino poder) {
        poderFinal = (poder.ataquePoder * this.ataque);
        dano = poderFinal - feiticeiro.defesa;
        if (this.vida <= 0) {
            System.out.println(this.nome + " atacou " + feiticeiro.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está morto)");
        } else if (poder.custoFe > this.fe) {
            System.out.println(this.nome + " atacou " + feiticeiro.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está sem fé)");
        } else {
            this.fe -= poder.custoFe;
            feiticeiro.vida -= dano;
            if (feiticeiro.vida <= 0) {
                feiticeiro.vida = 0; //para não negativar a vida
                System.out.println(this.nome + " atacou " + feiticeiro.nome + " com " + poder.nome + " causando " + dano + " de dano e matou o personagem alvo.");
            } else {
                System.out.println(this.nome + " atacou " + feiticeiro.nome + " com " + poder.nome + " causando " + dano + " de dano.");
            }
        }
    }

    public void ataque(Guerreiro guerreiro, PoderDivino poder) {
        poderFinal = (poder.ataquePoder * this.ataque);
        dano = poderFinal - guerreiro.defesa;
        if (this.vida <= 0) {
            System.out.println(this.nome + " atacou " + guerreiro.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está morto)");
        } else if (poder.custoFe > this.fe) {
            System.out.println(this.nome + " atacou " + guerreiro.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está sem fé)");
        } else {
            this.fe -= poder.custoFe;
            guerreiro.vida -= dano;
            if (guerreiro.vida <= 0) {
                guerreiro.vida = 0; //para não negativar a vida
                System.out.println(this.nome + " atacou " + guerreiro.nome + " com " + poder.nome + " causando " + dano + " de dano e matou o personagem alvo.");
            } else {
                System.out.println(this.nome + " atacou " + guerreiro.nome + " com " + poder.nome + " causando " + dano + " de dano.");
            }
        }

    }

    public void ataque(Mago mago, PoderDivino poder) {
        poderFinal = (poder.ataquePoder * this.ataque);
        dano = poderFinal - mago.defesa;
        if (this.vida <= 0) {
            System.out.println(this.nome + " atacou " + mago.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está morto)");
        } else if (poder.custoFe > this.fe) {
            System.out.println(this.nome + " atacou " + mago.nome + " com " + poder.nome + " causando 0 de dano. (Atacante está sem fé)");
        } else {
            this.fe -= poder.custoFe;
            mago.vida -= dano;
            if (mago.vida <= 0) {
                mago.vida = 0; //para não negativar a vida
                System.out.println(this.nome + " atacou " + mago.nome + " com " + poder.nome + " causando " + dano + " de dano e matou o personagem alvo.");
            } else {
                System.out.println(this.nome + " atacou " + mago.nome + " com " + poder.nome + " causando " + dano + " de dano.");
            }
        }
    }

    public void imprimirEstado() {
        System.out.println("Clérigo | Nome: " + this.nome + " | Vida: " + this.vida + " | Fé: " + this.fe);
    }
}
