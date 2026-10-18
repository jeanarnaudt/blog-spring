const root = document.documentElement;
const prefersDark = window.matchMedia('(prefers-color-scheme: dark)');

function applyTheme(theme) {
	root.setAttribute('data-theme', theme);
	const toggle = document.getElementById('toggle');
	if (toggle) toggle.checked = theme === 'dark';
}

// Initial theme: saved choice, otherwise OS preference
applyTheme(localStorage.getItem('theme') ?? (prefersDark.matches ? 'dark' : 'light'));

document.addEventListener('DOMContentLoaded', () => {
	const toggle = document.getElementById('toggle');
	toggle.checked = root.getAttribute('data-theme') === 'dark';
	toggle.addEventListener('change', () => {
		const theme = toggle.checked ? 'dark' : 'light';
		localStorage.setItem('theme', theme);
		applyTheme(theme);
	});
});

// Follow OS changes only while the user hasn't chosen explicitly
prefersDark.addEventListener('change', (e) => {
	if (!localStorage.getItem('theme')) applyTheme(e.matches ? 'dark' : 'light');
});
