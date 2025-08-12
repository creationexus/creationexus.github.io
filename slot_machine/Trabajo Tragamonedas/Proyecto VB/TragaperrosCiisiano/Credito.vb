Public Class Credito

    Private c As Integer = 0

    Public Sub New(ByVal x As Integer)
        c = x
    End Sub

    Public Function Get_Credito()
        Return c
    End Function

    Public Sub Set_Credito(ByVal x As Integer)
        c = x
    End Sub
    Public Sub descuento()
        If (Get_Credito() < 900000) Then
            If (Get_Credito() >= 200) Then
                Form1.btnLanzar.Enabled = False
                Set_Credito(Get_Credito() - 200)
                Form1.lb_cre.Text = (Get_Credito())
                Run()
            Else
                MsgBox("Dinero Insuficiente", MsgBoxStyle.Critical, "Dinero Insuficiente")
            End If
        Else
            MsgBox("Demasiado Dinero en la Maquina, Cobre sus Creditos Primero", MsgBoxStyle.OkOnly, "Sobrecarga en la Maquina")
        End If
    End Sub

    Public Sub Creditox2()
        Set_Credito(c * 2)
        Form1.lb_cre.Text = (Get_Credito())

    End Sub

    Public Sub Creditox3()
        Set_Credito(c * 3)
        Form1.lb_cre.Text = (Get_Credito())
    End Sub

    Public Sub Creditox4()
        Set_Credito(c * 4)
        Form1.lb_cre.Text = (Get_Credito())
    End Sub

    Public Sub Creditokiwi()
        Set_Credito(c + 1000)
        Form1.lb_cre.Text = (Get_Credito())
    End Sub

    Public Sub CreditoPodrido()
        If (Get_Credito() < 2500) Then
            Set_Credito(0)
            Form1.lb_cre.Text = (Get_Credito())
        Else
            Set_Credito(c - 2500)
            Form1.lb_cre.Text = (Get_Credito())
        End If

    End Sub

    Public Sub CreditoPera()
        Set_Credito(c + 500)
        Form1.lb_cre.Text = (Get_Credito())
    End Sub

    Public Sub Creditoplatano()
        Set_Credito(c + 250)
        Form1.lb_cre.Text = (Get_Credito())
    End Sub

End Class


