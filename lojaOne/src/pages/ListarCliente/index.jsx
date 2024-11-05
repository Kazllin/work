import React, { useEffect, useState } from 'react';
import api from '../../service/api';
import { useAuth } from '../../service/AuthContext';
import './ListarClientes.css'

const ListarClientes = () => {
    const [clientes, setClientes] = useState([]);
    const [message, setMessage] = useState("");
    const { user } = useAuth(); // Obter informações do usuário autenticado

    useEffect(() => {
        const fetchClientes = async () => {
            try {
                const token = localStorage.getItem("token");
                const response = await api.get("funcionario/clientes", {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                setClientes(response.data);
            } catch (error) {
                console.error("Erro ao buscar clientes:", error);
                setMessage("Erro ao buscar clientes.");
            }
        };

        fetchClientes();
    }, []);

    const handleDelete = async (id) => {
        try {
            const token = localStorage.getItem("token");
            await api.delete(`funcionario/clientes/${id}`, {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });
            setClientes(clientes.filter(cliente => cliente.id !== id));
            setMessage("Cliente deletado com sucesso!");
        } catch (error) {
            console.error("Erro ao deletar cliente:", error);
            setMessage("Erro ao deletar cliente.");
        }
    };

    return (
        <div className="container2">
            <h2>Lista de Clientes</h2>
            {message && <p>{message}</p>}
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {clientes.map(cliente => (
                        <tr key={cliente.id}>
                            <td>{cliente.id}</td>
                            <td>{cliente.nome}</td>
                            <td>{cliente.email}</td>
                            <td>
                                <button onClick={() => handleDelete(cliente.id)}>Deletar</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ListarClientes;