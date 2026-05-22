package br.sp.etec.sebrae.api_login.controller

import br.sp.etec.sebrae.api_login.entity.Boleto
import br.sp.etec.sebrae.api_login.entity.Usuario
import br.sp.etec.sebrae.api_login.repository.BoletoRepository
import br.sp.etec.sebrae.api_login.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@CrossOrigin(origins = ["*"])
@Controller
class BoletoController {

    @Autowired
    var repository: BoletoRepository? = null

    @PostMapping("/cadastro-boleto")
    fun cadastroBoleto(@RequestBody boleto: Boleto) : ResponseEntity<Boleto> {
        return ResponseEntity.ok(repository!!.save(boleto))
    }

    @GetMapping("/boletos")
    fun listBoletos(): List<Boleto> {
        return repository!!.findAll()
    }
}