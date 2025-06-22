package com.domhelder.reserve.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDate dataReserva;

    @Transient
    private List<DiaReserva> diasReservados;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "solicitante_id")
    private User solicitante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sala_id")
    private Sala salaReservada;

    private String disciplinaRelacionada;

    private String motivoReserva;

    private LocalDateTime dataInicio;

    private LocalDateTime dataConclusao;

    @Column(nullable = false)
    private LocalDateTime dataDaSolicitacao;


    public Reserva() {
        this.dataDaSolicitacao = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public LocalDateTime getDataDaSolicitacao() {
        return dataDaSolicitacao;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public List<DiaReserva> getDiasReservados() {
        return diasReservados;
    }

    public void setDiasReservados(List<DiaReserva> diasReservados) {
        this.diasReservados = diasReservados;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public User getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(User solicitante) {
        this.solicitante = solicitante;
    }

    public Sala getSalaReservada() {
        return salaReservada;
    }

    public void setSalaReservada(Sala salaReservada) {
        this.salaReservada = salaReservada;
    }

    public String getDisciplinaRelacionada() {
        return disciplinaRelacionada;
    }

    public void setDisciplinaRelacionada(String disciplinaRelacionada) {
        this.disciplinaRelacionada = disciplinaRelacionada;
    }

    public String getMotivoReserva() {
        return motivoReserva;
    }

    public void setMotivoReserva(String motivoReserva) {
        this.motivoReserva = motivoReserva;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}