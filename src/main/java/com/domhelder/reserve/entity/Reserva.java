package com.domhelder.reserve.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDate dataReserva;

    @ElementCollection(targetClass = Horarios.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "reserva_horarios", joinColumns = @JoinColumn(name = "reserva_id"))
    @Column(name = "horario")
    private List<Horarios> horariosReservados;

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

    @Column(nullable = false)
    private LocalDateTime dataSolicitacao;

    private LocalDateTime dataConclusao;

    public Reserva() {}

    public UUID getId() {
        return id;
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

    public List<Horarios> getHorariosReservados() {
        return horariosReservados;
    }

    public void setHorariosReservados(List<Horarios> horariosReservados) {
        this.horariosReservados = horariosReservados;
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

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
