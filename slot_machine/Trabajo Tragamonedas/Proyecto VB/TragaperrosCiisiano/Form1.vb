Public Class Form1
    'Autores: Gustavo Canales & Carlos Arriagada

    Public c As Credito = New Credito(0)

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btn_cobrar.Click
        btn_cobrar.Image = TragaperrosCiisiano.My.Resources.Resources.cob_2
        MsgBox(("Tu Dinero es $" & c.Get_Credito() & ""), MsgBoxStyle.OkOnly, "Pago")
        c.Set_Credito(0)
        lb_cre.Text = (c.Get_Credito())
        btn_cobrar.Image = TragaperrosCiisiano.My.Resources.Resources.cob_1
    End Sub

    Private Sub btnLanzar_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnLanzar.Click
        c.descuento()
    End Sub

    Private Sub bt_din_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles bt_din.Click
        Try
            If (c.Get_Credito < 900000) Then
                Dim ing As Integer
                ing = (InputBox("Ingrese Dinero a Jugar (Maximo $100.000): ", "Creditos", 5000))
                If (ing > 100000) Then
                    MsgBox("El Maximo de Ingreso es $100.000, Solo se le han descontado $100.000", MsgBoxStyle.OkOnly, "Demasiado Dinero")
                    c.Set_Credito(100000 + c.Get_Credito())
                    lb_cre.Text = (c.Get_Credito())
                Else
                    c.Set_Credito(ing + c.Get_Credito())
                    lb_cre.Text = (c.Get_Credito())
                End If
            Else
                MsgBox("Demasiado Dinero en la Maquina, Cobre sus Creditos Primero", MsgBoxStyle.OkOnly, "Sobrecarga en la Maquina")
            End If

        Catch InvalidCastException As Exception
            c.Set_Credito(c.Get_Credito())
            lb_cre.Text = (c.Get_Credito())
        End Try

    End Sub

    Dim ff As Aleatoria = New Aleatoria()

    Private Sub Timer1_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer1.Tick
        ff.randI()
    End Sub

End Class
