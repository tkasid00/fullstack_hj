
//별 만들기
const field = document.getElementById('starfield');
for (let i = 0; i < 100; i++) {
  const star = document.createElement('div');
  star.className = 'star';
  star.style.top = `${Math.random() * window.innerHeight}px`;
  star.style.left = `${Math.random() * window.innerWidth}px`;
  star.style.animationDuration = `${1 + Math.random() * 2}s`;
  field.appendChild(star);
}